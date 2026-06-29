package edu.hibernate.controller;


import edu.hibernate.dto.authDTO.LoginRequestDTO;
import edu.hibernate.dto.authDTO.RegisterRequestDTO;
import edu.hibernate.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("users")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO request){
        String token = usuarioService.login(request);
        return ResponseEntity.ok(Map.of("Key", token));
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO request){
        usuarioService.register(request);
        return ResponseEntity.ok().body(Map.of("sucesso", "Usuário criado com sucesso"));
    }

}
