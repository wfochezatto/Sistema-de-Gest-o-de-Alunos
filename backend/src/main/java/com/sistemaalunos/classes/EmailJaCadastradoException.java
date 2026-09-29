package com.sistemaalunos.classes;

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException() {
        super("E-mail já cadastrado");
    }
}