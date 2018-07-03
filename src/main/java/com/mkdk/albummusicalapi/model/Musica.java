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
public class Musica implements ModelInterface, Serializable {

    private static final long serialVersionUID = 3541230780921558675L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_musica")
    private Integer id;

    @NotNull
    private String nome;
    private Integer duracao;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "musica_album",
            joinColumns = @JoinColumn(name = "id_musica"),
            inverseJoinColumns = @JoinColumn(name = "id_album"))
    private List<Album> albuns = new ArrayList<>();
}
