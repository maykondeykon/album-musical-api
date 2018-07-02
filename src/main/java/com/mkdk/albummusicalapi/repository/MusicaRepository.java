package com.mkdk.albummusicalapi.repository;

import com.mkdk.albummusicalapi.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    List<Musica> findAllByNome(String nome);

    Musica findFirstByNome(String nome);
}
