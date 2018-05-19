package com.mkdk.albummusicalapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Integer id;

    private String nome;

    private String nacionalidade;
}
