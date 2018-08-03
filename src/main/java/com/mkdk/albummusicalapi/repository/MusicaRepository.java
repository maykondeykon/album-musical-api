package com.mkdk.albummusicalapi.repository;

import com.mkdk.albummusicalapi.model.Musica;
import com.mkdk.albummusicalapi.repository.Musica.MusicaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer>, MusicaRepositoryQuery {
    List<Musica> findAllByNome(String nome);

    Musica findFirstByNome(String nome);
}
