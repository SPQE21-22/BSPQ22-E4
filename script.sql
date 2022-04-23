

create database udeusto;

CREATE TABLE user
(
  id_user integer NOT NULL,
  first_name varchar(250) NOT NULL,
  last_name varchar(250) NOT NULL,
  password varchar(250),
  address varchar(250) NOT NULL,
  card_number varchar(250) NOT NULL,
  phone_number varchar(250) NOT NULL,
  user_name varchar(250) NOT NULL
);

