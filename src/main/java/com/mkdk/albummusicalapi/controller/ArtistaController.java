package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.model.Artista;
import com.mkdk.albummusicalapi.service.ArtistaService;
import com.mkdk.albummusicalapi.service.GenericServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController extends GenericController<Artista> {

    private ArtistaService artistaService;

    public ArtistaController(GenericServiceInterface<Artista> service, ArtistaService artistaService) {
        super(service);
        this.artistaService = artistaService;
    }

    @GetMapping
    public ResponseEntity<List<Artista>> listar() {
        return super.listar();
    }

    @GetMapping("/{id}")
    public Artista buscarPor(@PathVariable Integer id) {
        return super.buscarPor(id);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Artista>> buscaPorNome(@PathVariable String nome) {
        List<Artista> eList = artistaService.getAllByNome(nome);
        if (eList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(eList);
        }
    }

    @GetMapping("/nacionalidade/{nacionalidade}")
    public ResponseEntity<List<Artista>> buscaPorNacionalidade(@PathVariable String nacionalidade) {
        List<Artista> eList = artistaService.getAllByNacionalidade(nacionalidade);
        if (eList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(eList);
        }
    }

    @PostMapping
    public ResponseEntity<?> novo(@Validated @RequestBody Artista entity) {
        return super.novo(entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody
    void excluir(@PathVariable Integer id) {
        super.excluir(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualizar(@PathVariable Integer id, @Validated @RequestBody Artista entity) {
        return super.atualizar(id, entity);
    }
}
