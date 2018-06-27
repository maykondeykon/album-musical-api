package com.mkdk.albummusicalapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data

public class Album implements ModelInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_album")
    private Integer id;

    @NotNull
    private String nome;
    private Integer ano;
}
