package com.example.Escola.domain.aluno;

import com.example.Escola.domain.aluno.Aluno;

public record DadosDetalhamentoAluno(Long id, String nome, String email, String cpf, String telefone, Integer idade ) {

    public DadosDetalhamentoAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getTelefone(), aluno.getIdade());
    }

}
