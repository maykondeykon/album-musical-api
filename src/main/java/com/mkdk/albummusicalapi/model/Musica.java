package com.mkdk.albummusicalapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
}
