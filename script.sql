CREATE DATABASE IF NOT EXISTS udeusto;
USE udeusto;


CREATE TABLE 'user'
(
  id_user integer NOT NULL,
  first_name varchar(250) NOT NULL,
  last_name varchar(250) NOT NULL,
  password varchar(250),
  address varchar(250) NOT NULL,
  card_number varchar(250) NOT NULL,
  phone_number varchar(250) NOT NULL,
  user_name varchar(250) NOT NULL,
   PRIMARY KEY (`id_user`)
);


INSERT INTO user (id_user, first_name, last_name, password, address, card_number,phone_number,user_name)
VALUES (0, 'Juan', 'Gil', 'pass123', 'love st 123', '123456','123123','juan');

INSERT INTO user (id_user, first_name, last_name, password, address, card_number,phone_number,user_name)
VALUES (1, 'Pepe', 'Viyuela', 'root', 'tie st 123', '123456','123123','pepe');

