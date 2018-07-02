CREATE TABLE IF NOT EXISTS artista
(
    id_artista int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    nacionalidade varchar(255)
);

INSERT INTO artista (nome, nacionalidade) VALUES ('Midnight Rider', 'Brasil');
INSERT INTO artista (nome, nacionalidade) VALUES ('Helloween', 'Alemanha');