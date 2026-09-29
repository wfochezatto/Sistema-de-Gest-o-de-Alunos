package com.sistemaalunos.classes;

public class Aluno extends Pessoa {

    private String matricula;

    private String curso;

    public Aluno(String nome, String email, String telefone, String matricula, String curso) {
        super(nome, email, telefone);
        this.matricula = matricula;
        this.curso = curso;
    }

}
