CREATE TABLE professores (
    id SERIAL PRIMARY KEY,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    telefone varchar(15) not null unique,
    idade integer not null,
    cidade varchar(100) not null,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    numero integer not null,
    complemento varchar(100)
);