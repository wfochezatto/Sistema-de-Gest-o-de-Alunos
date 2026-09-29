package com.sistemaalunos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaAlunosApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaAlunosApplication.class, args);
        System.out.println("Sistema de Gestão de Alunos iniciado com sucesso!");
    }
}
