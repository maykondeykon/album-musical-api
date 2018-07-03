package com.mkdk.albummusicalapi.repository;

import com.mkdk.albummusicalapi.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Album findFirstByNome(String nome);

//    @Query("select a from Album left join ")
//    List<Album> findAllByArtistaId(Integer ArtistaId);
}
