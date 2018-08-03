package com.mkdk.albummusicalapi.repository.filter;

import lombok.Getter;
import lombok.Setter;

public class MusicaFilter {
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private Integer duracao;
    @Getter
    @Setter
    private String autor;
}
