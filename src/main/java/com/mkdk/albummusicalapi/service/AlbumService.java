package com.mkdk.albummusicalapi.service;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.repository.AlbumRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService implements GenericServiceInterface<Album>{

    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album getBy(String nome) {
        return albumRepository.findAlbumByNome(nome);
    }

    public Album getBy(Integer id) {
        Optional<Album> album = albumRepository.findById(id);
        return album.orElseThrow(() -> new IllegalArgumentException("Album não encontrado"));
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

    public void delete(Integer id) {
        if (albumRepository.existsById(id))
            albumRepository.deleteById(id);
    }

    public Album update(Integer id, Album album) {
        Album atualiza = this.getBy(id);
        BeanUtils.copyProperties(album, atualiza, "id");
        this.save(atualiza);
        return atualiza;
    }
}
