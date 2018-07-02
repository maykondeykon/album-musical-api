package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.service.AlbumService;
import com.mkdk.albummusicalapi.service.GenericServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albuns")
public class AlbumController extends GenericController<Album> {

    public AlbumController(GenericServiceInterface<Album> service) {
        super(service);
    }

    @GetMapping
    public ResponseEntity<List<Album>> listar() {
        return super.listar();
    }

    @GetMapping("/{id}")
    public Album buscarPor(@PathVariable Integer id) {
        return super.buscarPor(id);
    }

    @PostMapping
    public ResponseEntity<?> novo(@Validated @RequestBody Album entity) {
        return super.novo(entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody
    void excluir(@PathVariable Integer id) {
        super.excluir(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> atualizar(@PathVariable Integer id, @Validated @RequestBody Album entity) {
        return super.atualizar(id, entity);
    }
}
