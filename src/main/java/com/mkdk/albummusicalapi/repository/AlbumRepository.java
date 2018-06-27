package com.mkdk.albummusicalapi.repository;

import com.mkdk.albummusicalapi.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Album findFirstByNome(String nome);
}
