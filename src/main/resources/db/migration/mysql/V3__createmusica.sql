CREATE TABLE IF NOT EXISTS musica
(
    id_musica int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    duracao int
);

INSERT INTO musica (nome, duracao) VALUES ('Midnight Rider', 3);
INSERT INTO musica (nome, duracao) VALUES ('Eagle fly free', 4);