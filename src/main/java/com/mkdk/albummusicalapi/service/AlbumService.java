package com.mkdk.albummusicalapi.service;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album getBy(String nome) {
        return albumRepository.findAlbumByNome(nome);
    }

    public Optional<Album> getBy(Integer id) {
        return albumRepository.findById(id);
    }

    public List<Album> getAll() {
        return Optional.of(albumRepository.findAll()).orElse(new ArrayList<>());
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public void delete(Album album) {
        albumRepository.delete(album);
    }
}
