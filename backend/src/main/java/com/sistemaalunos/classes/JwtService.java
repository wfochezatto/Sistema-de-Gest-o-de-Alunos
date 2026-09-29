package com.sistemaalunos.classes;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET = "sua-chave-secreta-bem-grande-aqui";
    private final long EXPIRACAO = 1000 * 60 * 60; // 1 hora

    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
            .setSubject(usuario.getEmail())
            .claim("id", usuario.getId())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRACAO))
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .compact();
    }

    public String extrairEmail(String token) {
        return Jwts.parser()
            .setSigningKey(SECRET)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public boolean tokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}