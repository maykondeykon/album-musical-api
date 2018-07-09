package com.mkdk.albummusicalapi.repository;

import com.mkdk.albummusicalapi.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Album findFirstByNome(String nome);

    @Query(value = "select a.* from artista_album ab " +
                    "join album a on a.id_album = ab.id_album " +
                    "where ab.id_artista = :idartista", nativeQuery = true)
    List<Album> findAllByArtistaId(@Param("idartista") Integer idartista);
}
