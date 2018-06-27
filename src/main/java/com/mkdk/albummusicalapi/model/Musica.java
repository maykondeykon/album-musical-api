package com.mkdk.albummusicalapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Musica implements ModelInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_musica")
    private Integer id;

    private String nome;

    private Integer duracao;
}
