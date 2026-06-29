package edu.hibernate.service;

import edu.hibernate.config.security.JwtService;
import edu.hibernate.dto.authDTO.LoginRequestDTO;
import edu.hibernate.dto.authDTO.RegisterRequestDTO;
import edu.hibernate.model.Usuario;
import edu.hibernate.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private JwtService jwtService;
    private AuthenticationManager authenticationManager;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(JwtService jwtService, AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
    }

    public String login(LoginRequestDTO request){

        Authentication authentication = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        authenticationManager.authenticate(authentication);

        return jwtService.generateToken(request.username());
    }

    @Transactional
    public void register(RegisterRequestDTO request) {
        Usuario usuario = new Usuario(request);
        usuarioRepository.save(usuario);
    }
}
