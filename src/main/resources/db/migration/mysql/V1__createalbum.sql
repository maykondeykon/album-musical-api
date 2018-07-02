CREATE TABLE IF NOT EXISTS album
(
    id_album int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    ano int
);

INSERT INTO album (nome, ano) VALUES ('Midnight Rider', 2004);
INSERT INTO album (nome, ano) VALUES ('March for the Glory', 2008);
INSERT INTO album (nome, ano) VALUES ('Keeper of the seven keys Pt 1', 1987);
INSERT INTO album (nome, ano) VALUES ('Keeper of the seven keys Pt 2', 1988);