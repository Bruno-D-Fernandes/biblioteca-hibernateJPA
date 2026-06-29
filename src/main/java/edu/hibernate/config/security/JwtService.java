package edu.hibernate.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtService {

    private final String SECRET = "ChaveSECRETA-que-vousubirproGitHub,blbalabalba312423423";

    public String generateToken(String username){
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.create()
                .withIssuer("jwt-auth")
                .withSubject(username)
                .withExpiresAt(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")))
                .sign(algorithm);
    }

    // Esse parceiro retorna o sujeito dono do token, o filtro personalizado
    // valida o token, tudo que o filtro quer é o sujeito
    public String validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        try {
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (RuntimeException e) {
            // Aqui eu posso fazer uma exceção
            return "";
        }
    }

}
