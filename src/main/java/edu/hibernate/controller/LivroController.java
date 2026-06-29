package edu.hibernate.controller;

import edu.hibernate.dto.livroDTO.LivroResponseDTO;
import edu.hibernate.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("livros")
public class LivroController {

    private LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity getAllDicionarioLivro(){
        List<LivroResponseDTO> livroList = livroService.getAllLivroCategoriaAutor();
        return ResponseEntity.ok(livroList);
    }

}
