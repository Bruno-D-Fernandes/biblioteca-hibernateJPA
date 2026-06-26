package edu.hibernate.service;

import edu.hibernate.entity.Livro;
import edu.hibernate.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }


    public List<Livro> getAllLivroCategoriaAutor() {
        return livroRepository.findAll();
    }
}
