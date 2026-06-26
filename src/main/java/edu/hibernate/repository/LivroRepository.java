package edu.hibernate.repository;

import edu.hibernate.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query("SELECT DISTINCT l FROM Livro l " +
            "JOIN FETCH l.autor " +
            "LEFT JOIN FETCH l.categorias")
    List<Livro> getAllLivroCategoriaAutor();
}
