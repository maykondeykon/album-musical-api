CREATE TABLE IF NOT EXISTS album
(
    id_album int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    ano int
);

INSERT INTO album (nome, ano) VALUES ('Midnight Rider', 2004);
INSERT INTO album (nome, ano) VALUES ('March for the Glory', 2008);