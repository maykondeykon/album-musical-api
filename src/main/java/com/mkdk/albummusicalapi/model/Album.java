package com.mkdk.albummusicalapi.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
    @Transient
    @Getter
    private Integer duracao;

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

    @PostLoad
    private void setDuracao() {
        AtomicReference<Integer> duracaoInicial = new AtomicReference<>(0);

        if (musicas.size() > 0) {
            musicas.stream()
                    .forEach(musica -> {
                        duracaoInicial.updateAndGet(v -> v + musica.getDuracao());
                    });
        }

        this.duracao = duracaoInicial.get();
    }

    public List<String> getParticipantes() {
        List<String> artistas = new ArrayList<>();

        participantes.stream().forEach(artista -> {
            artistas.add(artista.getNome());
        });

        return artistas;
    }
}
