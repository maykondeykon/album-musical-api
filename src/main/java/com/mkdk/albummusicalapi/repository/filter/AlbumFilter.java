package com.mkdk.albummusicalapi.repository.filter;

import lombok.Getter;
import lombok.Setter;

public class AlbumFilter {

    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private Integer ano;
    @Getter
    @Setter
    private Integer duracao;
}
