package com.mkdk.albummusicalapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Artista implements ModelInterface, Serializable {

    private static final long serialVersionUID = 1849009335681411153L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Integer id;

    @NotNull
    private String nome;
    private String nacionalidade;
}
