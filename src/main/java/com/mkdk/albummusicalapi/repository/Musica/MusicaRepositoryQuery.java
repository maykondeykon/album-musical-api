package com.mkdk.albummusicalapi.repository.Musica;

import com.mkdk.albummusicalapi.model.Musica;
import com.mkdk.albummusicalapi.repository.filter.MusicaFilter;

import java.util.List;

public interface MusicaRepositoryQuery {
    List<Musica> filtrar(MusicaFilter filter);
}
