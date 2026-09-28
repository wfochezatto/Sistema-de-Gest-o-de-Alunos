CREATE DATABASE IF NOT EXISTS sistema_alunos
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE sistema_alunos;

CREATE TABLE IF NOT EXISTS alunos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(180) NOT NULL,
    data_nascimento DATE,
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_alunos_email (email)
);
