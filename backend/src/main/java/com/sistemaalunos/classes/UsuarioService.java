package com.sistemaalunos.classes;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class UsuarioService {
    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    public Usuario cadastrar(RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailJaCadastradoException();
        }

        String hash = passwordEncoder.encode(request.getSenha());
        Usuario usuario = new Usuario(request.getEmail(), hash);
        return usuarioRepository.save(usuario);
    }
}
