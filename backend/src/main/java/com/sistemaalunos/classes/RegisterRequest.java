package com.sistemaalunos.classes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public class RegisterRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}