package com.mkdk.albummusicalapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "artista_album",
            joinColumns = @JoinColumn(name = "id_artista"),
            inverseJoinColumns = @JoinColumn(name = "id_album"))
    private List<Album> albuns = new ArrayList<>();
}
