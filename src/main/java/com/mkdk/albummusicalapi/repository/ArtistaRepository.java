package com.mkdk.albummusicalapi.repository;

import com.mkdk.albummusicalapi.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
    Artista findArtistaByNome(String nome);
}
