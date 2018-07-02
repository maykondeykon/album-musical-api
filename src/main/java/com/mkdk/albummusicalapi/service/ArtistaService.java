package com.mkdk.albummusicalapi.service;

import com.mkdk.albummusicalapi.model.Artista;
import com.mkdk.albummusicalapi.repository.ArtistaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService implements GenericServiceInterface<Artista> {

    private ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public Artista getBy(String nome) {
        return artistaRepository.findArtistaByNome(nome);
    }

    public Artista getBy(Integer id) {
        return Optional.of(artistaRepository.getOne(id))
                .orElseThrow(() -> new IllegalArgumentException("Artista não encontrado."));
    }

    public List<Artista> getAll() {
        return Optional.of(artistaRepository.findAll()).orElse(new ArrayList<>());
    }

    public List<Artista> getAllByNacionalidade(String nacionalidade) {
        return artistaRepository.findAllByNacionalidadeOrderByNomeAsc(nacionalidade);
    }

    public List<Artista> getAllByNome(String nome) {
        return artistaRepository.findAllByNomeOrderByNome(nome);
    }

    public Artista save(Artista artista) {
        return artistaRepository.save(artista);
    }

    public Artista update(Integer id, Artista entity) {
        Artista atualiza = this.getBy(id);
        BeanUtils.copyProperties(entity, atualiza, "id");
        this.save(atualiza);
        return atualiza;
    }

    public void delete(Integer id) {
        if (artistaRepository.existsById(id))
            artistaRepository.deleteById(id);
    }

    public void delete(Artista artista) {
        if (artista.getId() != null)
            this.delete(artista.getId());
    }
}
