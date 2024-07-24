package com.projeto.projetobiblioteca.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public Livro() {}

    public Livro(String isbn, String titulo, String categoria, int quantidade) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

