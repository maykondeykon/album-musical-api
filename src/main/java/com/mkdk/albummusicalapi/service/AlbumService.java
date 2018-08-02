package com.mkdk.albummusicalapi.service;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.repository.AlbumRepository;
import com.mkdk.albummusicalapi.repository.filter.AlbumFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService implements GenericServiceInterface<Album> {

    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album getBy(String nome) {
        return albumRepository.findFirstByNome(nome);
    }

    public Album getBy(Integer id) {
        Optional<Album> album = albumRepository.findById(id);
        return album.orElseThrow(() -> new IllegalArgumentException("Album não encontrado"));
    }

    public List<Album> getAll() {
        return Optional.of(albumRepository.findAll()).orElse(new ArrayList<>());
    }

    public List<Album> getAllByArtista(Integer artistaId) {
        return Optional.of(albumRepository.findAllByArtistaId(artistaId)).orElse(new ArrayList<>());
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public void delete(Album album) {
        this.delete(album.getId());
    }

    public void delete(Integer id) {
        if (albumRepository.existsById(id))
            albumRepository.deleteById(id);
    }

    public Album update(Integer id, Album entity) {
        Album atualiza = this.getBy(id);
        BeanUtils.copyProperties(entity, atualiza, "id");
        this.save(atualiza);
        return atualiza;
    }

    public List<Album> pesquisa(AlbumFilter filter) {
        return albumRepository.filtrar(filter);
    }
}
