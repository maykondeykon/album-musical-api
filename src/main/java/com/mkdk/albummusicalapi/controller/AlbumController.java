package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    public Album buscarPor(@PathVariable Integer id){
        return albumService.getBy(id);
    }

    @PostMapping
    public ResponseEntity<?> novo(@Validated @RequestBody Album album) {
        Album novo = albumService.save(album);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(novo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(novo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody
    void excluir(@PathVariable Integer id) {
        albumService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> atualizar(@PathVariable Integer id, @Validated @RequestBody Album album) {
        Album atualiza = albumService.update(id, album);
        return ResponseEntity.ok(atualiza);
    }
}
