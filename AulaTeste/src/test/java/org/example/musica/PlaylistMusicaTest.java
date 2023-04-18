package org.example.musica;

import org.example.biblioteca.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistMusicaTest {

    private PlaylistMusica playlistMusica;

    @BeforeEach
    public void setup(){
        playlistMusica = new PlaylistMusica("Músiquinhas da felicidade");
    }

    @Test
    public void getNomePlaylist(){
        assertEquals("Músiquinhas da felicidade", playlistMusica.getNome());
    }

    @Test
    public void setNomePlaylist(){
        playlistMusica.setNome("Musicas");
        assertEquals("Musicas", playlistMusica.getNome());
    }

    @Test
    public void getMusicasPlaylist(){
        Musica musica = new Musica("Som do amanhã", "Eu", 25);
        playlistMusica.adicionarMusica(musica);
        assertEquals(1, playlistMusica.getQuantidadeMusicas());
    }
    @Test
    public void addMusicaPlaylist(){
        Musica musica = new Musica("Som do amanhã", "Eu", 25);
        assertEquals(true, playlistMusica.adicionarMusica(musica));
    }

    @Test
    public void remMusicaPlaylist(){
        Musica musica = new Musica("Som do amanhã", "Eu", 25);
        playlistMusica.adicionarMusica(musica);
        assertEquals(true, playlistMusica.removerMusica(musica));
    }

    @Test
    public void buscarTituloMusicaPlaylist(){
        Musica musica = new Musica("Som do amanhã", "Eu", 25);
        playlistMusica.adicionarMusica(musica);
        assertEquals(musica, playlistMusica.buscarMusicaPorTitulo("Som do amanhã"));
    }

    @Test
    public void buscarMusicasArtistaPlaylist(){
        Musica musica = new Musica("Som do amanhã", "Eu", 25);
        playlistMusica.adicionarMusica(musica);
        assertEquals(1, playlistMusica.buscarMusicasPorArtista(musica.getArtista()).size());
    }

    @Test
    public void orderByTitleMusicaPlaylist(){
        Musica musica1 = new Musica("Som do amanhã", "Eu", 25);
        playlistMusica.adicionarMusica(musica1);
        Musica musica2 = new Musica("Amanhã", "Eu", 25);
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.ordenarPorTitulo();
        assertEquals(musica2, playlistMusica.getMusicas().get(0));
    }

    @Test
    public void orderByArtistMusicaPlaylist(){
        Musica musica1 = new Musica("Som do amanhã", "Eu", 25);
        playlistMusica.adicionarMusica(musica1);
        Musica musica2 = new Musica("Amanhã", "Você", 25);
        playlistMusica.adicionarMusica(musica2);
        Musica musica3 = new Musica("Amanhã", "André", 25);
        playlistMusica.adicionarMusica(musica3);
        playlistMusica.ordenarPorArtista();
        assertEquals(musica3, playlistMusica.getMusicas().get(0));
    }



}
