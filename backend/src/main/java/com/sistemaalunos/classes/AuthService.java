package com.sistemaalunos.classes;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // public void cadastrar(RegisterRequest request) {
    //     if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
    //         throw new EmailJaCadastradoException();
    //     }

    //     String hash = passwordEncoder.encode(request.getSenha());
    //     Usuario usuario = new Usuario(request.getNome(), request.getEmail(), hash);
    //     usuarioRepository.save(usuario);
    // }

    public LoginResponse autenticar(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new CredenciaisInvalidasException("Email ou senha inválidos"));

        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenhaHash())) {
            throw new CredenciaisInvalidasException("Email ou senha inválidos");
        }

        String token = jwtService.gerarToken(usuario);
        return new LoginResponse(token);
    }
}
