-- Inserir dados na tabela de Usuario
INSERT INTO hub_usuario (id, name, email, avatar_url) VALUES (99, 'Bruna Menegatti Vienna', 'rm96848@fiap.com.br', 'https://avatars.githubusercontent.com/u/99131108?v=4');
INSERT INTO hub_usuario (id, name, email, avatar_url) VALUES (98, 'Joao Carlos Lima', 'pfXXXXX@fiap.com.br', 'http://github.com/joaocarloslima.png');


-- Inserir dados nas tabelas Hotel e Quarto
INSERT INTO hotel (nm_hotel, end_hotel, img_hotel) VALUES ('Hotel Hilton Barra', 'Av. Embaixador Abelardo Bueno, 1430 - Rio de Janeiro / RJ' ,'https://media-cdn.tripadvisor.com/media/photo-s/2a/d5/e6/e9/exterior.jpg');
INSERT INTO hotel (nm_hotel, end_hotel, img_hotel) VALUES ('Casa Grande Hotel Resort & Spa', 'Av. Miguel Estefno, 1001 - Guaruja / SP' ,'https://cf.bstatic.com/xdata/images/hotel/max1024x768/27085997.jpg?k=f1c21d28e62f331f06bce4b0e25901d3afba8f65928cfb42703ca412b3e6fc20&o=&hp=1');
INSERT INTO hotel (nm_hotel, end_hotel, img_hotel, usuario_id) VALUES ('Club Med Lake Paradise', 'Rod. Eng. Candido do Rego Chaves, 4500 - Mogi das Cruzes / SP' ,'https://ns.clubmed.com/dream/PRODUCT_CENTER/DESTINATIONS/SUN/Amerique_du_sud___centrale/Bresil/Lake_Paradise/433356-f2jryrwv89-swhr.jpg', 99);

INSERT INTO quarto (tp_quarto, ds_quarto, qtd_quarto, id_hotel, valor_diaria_quarto, img_quarto) VALUES ('Standard', 'Quarto padrao', 20, 1, 150.00, 'https://coralplaza.com.br/wp-content/uploads/2018/07/194920-tipos-de-quarto-de-hotel-como-escolher-o-melhor-na-sua-hospedagem-1.jpg');
INSERT INTO quarto (tp_quarto, ds_quarto, qtd_quarto, id_hotel, valor_diaria_quarto, img_quarto) VALUES ('Deluxe', 'Quarto luxuoso', 15, 1, 300.00, 'https://media-cdn.tripadvisor.com/media/photo-s/0b/ac/bc/a3/quarto-deluxe.jpg');
INSERT INTO quarto (tp_quarto, ds_quarto, qtd_quarto, id_hotel, valor_diaria_quarto, img_quarto) VALUES ('Suite Premium', 'Suite para família', 3, 2, 1000.00, 'https://2.bp.blogspot.com/-M1tyrCU7OvE/Wbfdb0YixTI/AAAAAAAAYX0/X1Wdj1i0oXclB1nKNzhizbcl5fYpAIb4wCLcBGAs/s1600/Belmond%2BCopacabana%2BPalace%2B-%2BSuite%2Bcom%2Bvista%2Bpraia%2B%25281%2529.jpg');