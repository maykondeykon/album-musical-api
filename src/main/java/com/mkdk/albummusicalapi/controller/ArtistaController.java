package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.model.Artista;
import com.mkdk.albummusicalapi.service.ArtistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    private ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @GetMapping
    public ResponseEntity<List<Artista>> listaArtistas() {
        List<Artista> artistas = artistaService.getAll();
        if (artistas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(artistas);
        }
    }

    @GetMapping("/{id}")
    public Artista buscarPor(@PathVariable Integer id) {
        return artistaService.getBy(id);
    }

    @PostMapping
    public ResponseEntity<?> novo(@Validated @RequestBody Artista artista) {
        Artista novo = artistaService.save(artista);
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
        artistaService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualizar(@PathVariable Integer id, @Validated @RequestBody Artista artista) {
        Artista atualiza = artistaService.update(id, artista);
        return ResponseEntity.ok(atualiza);
    }
}
