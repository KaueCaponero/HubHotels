package br.com.fiap.hubhotels.hotel;

import br.com.fiap.hubhotels.quarto.QuartoRepository;
import br.com.fiap.hubhotels.usuario.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("hotels")
public class HotelController {

    @Autowired
    HotelRepository repository;

    @Autowired
    HotelService service;

    @Autowired
    QuartoRepository quartoRepository;

    @Autowired
    MessageSource messageSource;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal DefaultOAuth2User user) {
        Usuario myUser = (Usuario) user;
        model.addAttribute("hotels", repository.findAll());
        model.addAttribute("user", user.getAttribute("name"));
        model.addAttribute("avatar", user.getAttribute("avatar_url"));
        model.addAttribute("principal", myUser);
        return "hotel/index";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {

        var hotel = repository.findById(id);

        if (hotel.isEmpty()) {
            redirect.addFlashAttribute("errorMessage", messageSource.getMessage("hotel.notfound", null, LocaleContextHolder.getLocale()));
            return "redirect:/hotels";
        }

        quartoRepository.deleteByHotelId(id);
        repository.deleteById(id);
        redirect.addFlashAttribute("sucessMessage", messageSource.getMessage("hotel.delete", null, LocaleContextHolder.getLocale()));
        return "redirect:/hotels";
    }

    @GetMapping("new")
    public String form(Hotel hotel) {
        return "hotel/form";
    }

    @PostMapping
    public String create(@Valid Hotel hotel, BindingResult result, RedirectAttributes redirect) {   
        if (result.hasErrors()) return "hotel/form";

        repository.save(hotel);
        redirect.addFlashAttribute("sucessMessage", messageSource.getMessage("hotel.created", null, LocaleContextHolder.getLocale()));
        return "redirect:/hotels";
    }

    @PostMapping("/manage/{id}")
    public String manage(@PathVariable Long id, @AuthenticationPrincipal DefaultOAuth2User user) {
        Usuario myUser = (Usuario) user;
        service.manage(id, myUser);
        return "redirect:/hotels";
    }

    @PostMapping("/drop/{id}")
    public String drop(@PathVariable Long id, @AuthenticationPrincipal DefaultOAuth2User user) {
        Usuario myUser = (Usuario) user;
        service.drop(id, myUser);
        return "redirect:/hotels";
    }
}