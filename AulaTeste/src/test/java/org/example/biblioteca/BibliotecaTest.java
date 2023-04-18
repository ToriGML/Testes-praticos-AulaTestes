package org.example.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @BeforeEach
    public void setup(){
        biblioteca = new Biblioteca("Minha Biblioteca");
    }

    @Test //ff
    public void addLivro(){
        Livro livro = new Livro("Minha namorada", "Eu", "Drama", 999);
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.getQuantidadeLivros());

        Livro novoLivro = new Livro("Minha Ex-namorada", "Eu", "Suspense", 1005);
        biblioteca.adicionarLivro(novoLivro);
        assertEquals(2, biblioteca.getQuantidadeLivros());
    }

    @Test //fff
    public void remLivro(){
        Livro livro = new Livro("Minha (nova) namorada", "Eu", "Romance", 1005);
        biblioteca.adicionarLivro(livro);
        assertEquals(true, biblioteca.removerLivro(livro));
    }

    @Test //ff
    public void buscarAutorLivro(){
        Livro livro = new Livro("Minha (nova) namorada", "Eu", "Romance", 1005);
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.buscarLivrosPorAutor(livro.getAutor()).size());
    }

    @Test //ff
    public void buscarTituloLivro(){
        Livro livro = new Livro("Minha (nova/ex) namorada", "Eu", "Drama", 1005);
        biblioteca.adicionarLivro(livro);
        assertEquals(livro, biblioteca.buscarLivroPorTitulo("Minha (nova/ex) namorada"));
    }

    @Test
    public void buscarGeneroLivro(){
        Livro livro = new Livro("Minha (ex/nova) namorada", "Eu", "Suspense", 1005);
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.buscarLivrosPorGenero(livro.getGenero()).size());
    }

    @Test
    public void buscarQuantidadeLivros(){
        Livro livro = new Livro("Minha vida sem mulheres", "Eu", "Ação", 1005);
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.getQuantidadeLivros());
    }

    @Test
    public void buscarLivros(){
        Livro livro = new Livro("Minha vida sem mulheres", "Eu", "Ação", 1005);
        biblioteca.adicionarLivro(livro);
        assertEquals(livro, biblioteca.getLivros().get(0));
    }

    @Test
    public void setNomeBiblioteca(){
        biblioteca.setNome("Minha ex biblioteca");
        assertEquals("Minha ex biblioteca", biblioteca.getNome());
    }

    @Test
    public void getNomeBiblioteca(){
        assertEquals("Minha Biblioteca", biblioteca.getNome());
    }

}
