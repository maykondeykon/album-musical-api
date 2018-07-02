package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.model.Musica;
import com.mkdk.albummusicalapi.service.GenericServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController extends GenericController<Musica> {

    MusicaController(GenericServiceInterface<Musica> service) {
        super(service);
    }

    @GetMapping
    public ResponseEntity<List<Musica>> listar() {
        return super.listar();
    }

    @GetMapping("/{id}")
    public Musica buscarPor(@PathVariable Integer id) {
        return super.buscarPor(id);
    }

    @PostMapping
    public ResponseEntity<?> novo(@Validated @RequestBody Musica entity) {
        return super.novo(entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody
    void excluir(@PathVariable Integer id) {
        super.excluir(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(@PathVariable Integer id, @Validated @RequestBody Musica entity) {
        return super.atualizar(id, entity);
    }
}
