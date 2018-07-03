package com.mkdk.albummusicalapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Album implements ModelInterface, Serializable {

    private static final long serialVersionUID = 4552409660132068170L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_album")
    private Integer id;

    @NotNull
    private String nome;
    private Integer ano;

    @ManyToMany
    @JoinTable(name = "artista_album",
            joinColumns = @JoinColumn(name = "id_album"),
            inverseJoinColumns = @JoinColumn(name = "id_artista"))
    private List<Artista> participantes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "musica_album",
            joinColumns = @JoinColumn(name = "id_album"),
            inverseJoinColumns = @JoinColumn(name = "id_musica"))
    private List<Musica> musicas = new ArrayList<>();
}
