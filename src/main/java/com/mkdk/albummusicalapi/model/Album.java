package com.mkdk.albummusicalapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
}
