package edu.hibernate.entity;


import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "ano_publicacao")
    private OffsetDateTime anoPublicacao;

    // FK
    @Column(name = "autor_id")
    private int autor;


    public Livro(int id, String titulo, String isbn, OffsetDateTime anoPublicacao, int autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }

    public Livro() {
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", autor=" + autor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id == livro.id && autor == livro.autor && Objects.equals(titulo, livro.titulo) && Objects.equals(isbn, livro.isbn) && Objects.equals(anoPublicacao, livro.anoPublicacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, isbn, anoPublicacao, autor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public OffsetDateTime getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(OffsetDateTime anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }
}
