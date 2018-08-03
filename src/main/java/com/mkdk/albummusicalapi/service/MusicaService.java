package com.mkdk.albummusicalapi.service;

import com.mkdk.albummusicalapi.model.Musica;
import com.mkdk.albummusicalapi.repository.MusicaRepository;
import com.mkdk.albummusicalapi.repository.filter.MusicaFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusicaService implements GenericServiceInterface<Musica> {

    private MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    @Override
    public Musica getBy(Integer id) {
        return Optional.of(musicaRepository.getOne(id))
                .orElseThrow(() -> new IllegalArgumentException("Música não encontrada."));
    }

    @Override
    public Musica getBy(String termo) {
        return musicaRepository.findFirstByNome(termo);
    }

    public List<Musica> getAllBy(String termo) {
        return Optional.ofNullable(musicaRepository.findAllByNome(termo)).orElse(new ArrayList<>());
    }

    @Override
    public List<Musica> getAll() {
        return Optional.of(musicaRepository.findAll()).orElse(new ArrayList<>());
    }

    @Override
    public Musica save(Musica entity) {
        return musicaRepository.save(entity);
    }

    @Override
    public Musica update(Integer id, Musica entity) {
        Musica atualiza = this.getBy(id);
        BeanUtils.copyProperties(entity, atualiza, "id");
        this.save(atualiza);
        return atualiza;
    }

    @Override
    public void delete(Integer id) {
        musicaRepository.deleteById(id);
    }

    @Override
    public void delete(Musica entity) {
        if (entity.getId() != null)
            this.delete(entity.getId());
    }

    public List<Musica> pesquisar(MusicaFilter filter){
        return musicaRepository.filtrar(filter);
    }
}
