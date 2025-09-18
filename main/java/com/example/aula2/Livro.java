package com.example.aula2;

public class Livro {
    private String titulo;
    private String autor;
    private boolean concluido;

    public Livro(String titulo, String autor, boolean concluido) {
        this.titulo = titulo;
        this.autor = autor;
        this.concluido = concluido;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + (concluido ? " (Concluído)" : " (Não concluído)");
    }
}