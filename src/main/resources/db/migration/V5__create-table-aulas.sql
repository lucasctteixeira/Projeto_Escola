CREATE TABLE aulas (

    id bigint PRIMARY KEY,
    idProfessor bigint not null,
    idAluno bigint not null,
    data timestamp not null,


    constraint fk_aulas_professor_id foreign key(idProfessor) references professores(id),
    constraint fk_aulas_aluno_id foreign key(idAluno) references alunos(matricula)

);