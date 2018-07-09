package com.mkdk.albummusicalapi.controller;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.service.AlbumService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumControllerTest {

    @Autowired
    private AlbumService albumService;

    private Album albumBase;
    private Album novoAlbum;

    @Before
    public void setUp() throws Exception {
        createAlbum();
    }

    private void createAlbum() {
        albumBase = new Album();
        albumBase.setNome("Midnight Rider");
        albumBase.setAno(2004);

        novoAlbum = new Album();
        novoAlbum.setNome("March for the glory");
        novoAlbum.setAno(2008);
    }

    @Test
    public void listaAlbuns() {
        List<Album> albuns = albumService.getAll();
        assertTrue(albuns.size() > 0);
    }

    @Test
    public void buscarPor() {
        Integer id = 1;
        Album album = albumService.getBy(id);
        assertEquals(albumBase.getNome(), album.getNome());
        assertEquals(albumBase.getAno(), album.getAno());
    }

    @Test
    public void novo() {
        Album novo = albumService.save(novoAlbum);
        novoAlbum.setId(novo.getId());

        assertEquals(novoAlbum, novo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excluir() {
        this.novo();
        Album album = albumService.getBy(novoAlbum.getNome());
        Integer id = album.getId();
        albumService.delete(album);

        albumService.getBy(id);
    }

    @Test
    public void atualizar() {
        this.novo();
        Album album = albumService.getBy(novoAlbum.getNome());
        album.setNome(album.getNome()+"_2");

        Album atualizado = albumService.update(album.getId(), album);

        assertEquals(album, atualizado);
    }
}