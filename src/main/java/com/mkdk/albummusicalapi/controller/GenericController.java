package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.service.GenericServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class GenericController<E> {

    private GenericServiceInterface<E> service;

    GenericController(GenericServiceInterface<E> service) {
        this.service = service;
    }

    public ResponseEntity<List<E>> listar() {
        List<E> eList = service.getAll();
        if (eList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(eList);
        }
    }

    public E buscarPor(Integer id) {
        return service.getBy(id);
    }

    public ResponseEntity<?> novo(E entity) {
        E novo = service.save(entity);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(novo)//TODO retornar o id do objeto
                .toUri();
        return ResponseEntity.created(uri).body(novo);
    }

    public void excluir(Integer id) {
        service.delete(id);
    }

    public ResponseEntity<E> atualizar(Integer id, E entity) {
        E atualiza = service.update(id, entity);
        return ResponseEntity.ok(atualiza);
    }
}
