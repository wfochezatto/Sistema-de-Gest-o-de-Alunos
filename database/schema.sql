CREATE TABLE IF NOT EXISTS usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    Email VARCHAR(255) NOT NULL UNIQUE,
    Senha_hash VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cursos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    codigo VARCHAR(150) NOT NULL UNIQUE,
    carga_horaria SMALLINT UNSIGNED,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS alunos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    Data_Nascimento DATE NOT NULL,
    Telefone VARCHAR(30) NOT NULL,
    Matricula VARCHAR(20) NOT NULL UNIQUE,
    Data_Matricula DATE NOT NULL,
    curso_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_alunos_cursos
        FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

ALTER TABLE alunos
ADD COLUMN curso_id BIGINT NOT NULL,
ADD CONSTRAINT fk_alunos_cursos
    FOREIGN KEY (curso_id) REFERENCES cursos(id);

INSERT INTO cursos (codigo, carga_horaria) VALUES
    ('SI', 3000),
    ('ADS', 2000);

INSERT INTO alunos
    (nome, Data_Nascimento, Telefone, Matricula, Data_Matricula, curso_id)
SELECT 'Ana Souza', '2004-05-18', '(11) 98888-1111', 'ALU001', '2026-02-01', id
FROM cursos
WHERE codigo = 'SI';

INSERT INTO alunos
    (nome, Data_Nascimento, Telefone, Matricula, Data_Matricula, curso_id)
SELECT 'Bruno Lima', '2003-11-02', '(11) 97777-2222', 'ALU002', '2026-02-01', id
FROM cursos
WHERE codigo = 'ADS';

INSERT INTO alunos
    (nome, Data_Nascimento, Telefone, Matricula, Data_Matricula, curso_id)
SELECT 'Camila Rocha', '2005-03-24', '(11) 96666-3333', 'ALU003', '2026-02-01', id
FROM cursos
WHERE codigo = 'SI';