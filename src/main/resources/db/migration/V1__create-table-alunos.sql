CREATE TABLE alunos (
    matricula SERIAL PRIMARY KEY,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(9) not null unique,
    telefone varchar(15) not null unique,
    idade integer not null
);