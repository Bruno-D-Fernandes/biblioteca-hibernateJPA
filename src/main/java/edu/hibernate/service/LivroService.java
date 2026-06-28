package edu.hibernate.service;

import edu.hibernate.dto.LivroDTO.LivroResponseDTO;
import edu.hibernate.entity.Livro;
import edu.hibernate.repository.LivroRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private LivroRepository livroRepository;
    private EntityManager entityManager;

    @Autowired
    public LivroService(LivroRepository livroRepository, EntityManager entityManager) {
        this.livroRepository = livroRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public List<LivroResponseDTO> getAllLivroCategoriaAutor() {

        List<Livro> allLivroCategoriaAutor = livroRepository.getAllLivroCategoriaAutor();

        //Um detached deixa de ser rastreado pelo hibernate, bem "parecido" com o trancient
        // vai retornar com o título trocado para o usuário, porém no banco nada muda
        for (Livro livro : allLivroCategoriaAutor) {
            entityManager.detach(livro);
            livro.setTitulo("Trocado");
        }

        for (Livro livro : allLivroCategoriaAutor) {
            livroRepository.delete(livro);
        }


        List<LivroResponseDTO> livroResponseDTOS = allLivroCategoriaAutor.stream().
                map(LivroResponseDTO::new)
                .toList();

        return livroResponseDTOS;
    }
}
