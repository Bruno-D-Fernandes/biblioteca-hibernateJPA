package edu.hibernate.entity;


import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;
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
    private int anoPublicacao;

    @JoinColumn(name = "autor_id")
    @ManyToOne
    private Autor autor;

    @JoinTable(
            name = "livro_categoria",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @ManyToMany
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "livro")
    private List<Exemplar> exemplares;

    public Livro(int id, String titulo, String isbn, int anoPublicacao, Autor autor) {
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

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }
}
