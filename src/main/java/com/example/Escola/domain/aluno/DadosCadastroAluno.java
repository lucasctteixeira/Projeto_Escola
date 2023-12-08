package com.example.Escola.domain.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluno(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone,

        @NotNull
        Integer idade) {
}
