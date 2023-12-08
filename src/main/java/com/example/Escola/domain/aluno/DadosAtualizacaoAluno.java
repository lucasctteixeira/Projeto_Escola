package com.example.Escola.domain.aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(

        @NotNull
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        Integer idade
) {
}
