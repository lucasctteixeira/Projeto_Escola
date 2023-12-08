package com.example.Escola.domain.professor;

import com.example.Escola.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfessor(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotNull
        Integer idade,

        @NotNull
        Materia materia,
        @NotNull @Valid
        DadosEndereco endereco) {
}
