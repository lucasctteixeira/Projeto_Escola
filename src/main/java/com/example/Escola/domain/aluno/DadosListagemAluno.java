package com.example.Escola.domain.aluno;

public record DadosListagemAluno(Long id, String nome, String cpf, String email, String telefone, Integer idade) {


    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getEmail(), aluno.getTelefone(), aluno.getIdade());
    }

}
