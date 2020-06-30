INSERT INTO USER (name,email,password,contact,city) values ('admin','admin@admin.com','admin','5132433433','POA');
INSERT INTO USER (name,email,password,contact,city) values ('admin2','admin2@admin2.com','admin2','51332433433','POA2');

INSERT INTO VEHICLE (modelo,tipo,marca,placa,novo) values ('fiesta',1,1,'123',true);
INSERT INTO VEHICLE (modelo,tipo,marca,placa,novo) values ('fiesta2',1,0,'1234',false);
INSERT INTO ANUNCIO (user_id,title,description,vehicle_id, preco) values (1,'title test 1','description test 1', 1, 3500);
INSERT INTO ANUNCIO (user_id,title,description,vehicle_id, preco ) values (1,'title test 2','description test 2', 1, 7200);
INSERT INTO ANUNCIO (user_id,title,description,vehicle_id, preco) values (2,'title test 3','description test 3', 2, 4000);

