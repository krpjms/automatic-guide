drop table if EXISTS phones;
drop table if EXISTS usuarios;

CREATE TABLE usuarios (
  id uuid default random_uuid()  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  created Date not null,
  modified Date not null,
  lastLogin Date not null,
  active VARCHAR(1) not null,
  token VARCHAR(250)
);

CREATE TABLE phones (
  id uuid default random_uuid()  PRIMARY KEY,
  id_user uuid,
  number VARCHAR(250)  NULL,
  citycode VARCHAR(250)  NULL,
  countrycode VARCHAR(250) NULL
);

ALTER TABLE phones
    ADD FOREIGN KEY (id_user) 
    REFERENCES usuarios(id);
