package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/albuns")
public class AlbumController {

    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<List<Album>> listaAlbuns() {
        List<Album> albuns = albumService.getAll();
        if (albuns.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(albuns);
        }
    }
}
