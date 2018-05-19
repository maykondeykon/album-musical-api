CREATE SCHEMA album_musical;

CREATE TABLE IF NOT EXISTS album
(
    id_album int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    ano int
);

CREATE TABLE IF NOT EXISTS musica
(
    id_musica int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    duracao int
);

CREATE TABLE IF NOT EXISTS artista
(
    id_artista int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    nacionalidade varchar(255)
);

GRANT USAGE ON *.* TO `album_musical`@'localhost' IDENTIFIED BY '@l6um#mu2ic@l';
GRANT UPDATE ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT DELETE ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT DROP ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT CREATE TEMPORARY TABLES ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT LOCK TABLES ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT SHOW VIEW ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT SELECT ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT INSERT ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT CREATE VIEW ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT CREATE ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT INDEX ON album_musical.* TO `album_musical`@'localhost' 
GO
GRANT ALTER ON album_musical.* TO `album_musical`@'localhost'


