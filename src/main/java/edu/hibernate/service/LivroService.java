package edu.hibernate.service;

import edu.hibernate.dto.LivroDTO.LivroResponseDTO;
import edu.hibernate.entity.Livro;
import edu.hibernate.repository.LivroRepository;
import jakarta.transaction.Transactional;
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


    @Transactional
    public List<LivroResponseDTO> getAllLivroCategoriaAutor() {

        List<Livro> allLivroCategoriaAutor = livroRepository.getAllLivroCategoriaAutor();

        //Técnicamente eles estão MANAGED, então ao final, todos os livro se tornaram "Trocado" no banco
        for (Livro livro : allLivroCategoriaAutor) {
            livro.setTitulo("Trocado");
        }

        List<LivroResponseDTO> livroResponseDTOS = allLivroCategoriaAutor.stream().
                map(LivroResponseDTO::new)
                .toList();

        return livroResponseDTOS;
    }
}
