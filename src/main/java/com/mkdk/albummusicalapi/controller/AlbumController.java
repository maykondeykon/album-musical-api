package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albuns")
public class AlbumController extends GenericController<Album>{

    public AlbumController(AlbumService albumService) {
        super(albumService);
    }

    @GetMapping
    public ResponseEntity<List<Album>> listaAlbuns() {
        return this.listar();
    }

    @GetMapping("/{id}")
    public Album buscarPor(@PathVariable Integer id){
        return this.buscarPor(id);
    }

    @PostMapping
    public ResponseEntity<?> novo(@Validated @RequestBody Album album) {
        return this.novo(album);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody
    void excluir(@PathVariable Integer id) {
        this.excluir(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> atualizar(@PathVariable Integer id, @Validated @RequestBody Album album) {
        return this.atualizar(id, album);
    }
}
