package com.sistemaalunos.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.autenticar(request));
    }

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(usuarioService.cadastrar(request));
    }
}