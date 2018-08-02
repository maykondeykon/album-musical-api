package com.mkdk.albummusicalapi.repository.Album;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.repository.filter.AlbumFilter;

import java.util.List;

public interface AlbumRepositoryQuery {

    List<Album> filtrar(AlbumFilter albumFilter);
}
