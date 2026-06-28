package edu.hibernate.dto.LivroDTO;

import edu.hibernate.entity.Autor;
import edu.hibernate.entity.Livro;

import java.util.List;

public record LivroResponseDTO(
        int id,
               String titulo,
                               String isbn,
                               int anoPublicacao,
        String autor) {




    public LivroResponseDTO(int id, String titulo, String isbn, int anoPublicacao, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }

    public LivroResponseDTO(Livro livro) {


        this(livro.getId(),
        livro.getTitulo(),
        livro.getIsbn(),
        livro.getAnoPublicacao(),
        livro.getAutor().getNome()
        );
    }
}
