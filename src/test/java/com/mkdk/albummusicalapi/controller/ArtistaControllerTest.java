package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.model.Artista;
import com.mkdk.albummusicalapi.model.ModelInterface;
import com.mkdk.albummusicalapi.service.ArtistaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtistaControllerTest {

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private ArtistaController artistaController;

    private Artista artistaBase;

    private void createArtista() {
        artistaBase = new Artista();
        artistaBase.setNacionalidade("Brasileira");
        artistaBase.setNome("Midnight Rider");
    }

    @Before
    public void setUp() throws Exception {
        createArtista();
    }

    @Test
    public void listaArtistas() {
    }

    @Test
    public void buscarPor() {
    }

    @Test
    public void novo() {
        ResponseEntity<?> novo = artistaController.novo(artistaBase);
        assertEquals(201, novo.getStatusCodeValue());

    }

    @Test
    public void excluir() {
        ResponseEntity<?> novo = artistaController.novo(artistaBase);
        ModelInterface entity = (ModelInterface) novo.getBody();
        Integer id = entity.getId();

        artistaController.excluir(id);
        artistaController.buscarPor(id);
    }

    @Test
    public void atualizar() {
    }
}