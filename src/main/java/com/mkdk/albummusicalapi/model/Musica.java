package com.mkdk.albummusicalapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_musica")
    private Integer id;

    private String nome;

    private Integer duracao;
}
