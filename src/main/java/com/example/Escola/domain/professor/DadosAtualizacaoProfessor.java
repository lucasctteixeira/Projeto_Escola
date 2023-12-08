package com.example.Escola.domain.professor;

import com.example.Escola.domain.endereco.DadosEndereco;
import com.example.Escola.domain.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfessor(

        @NotNull
        Long id,

        String nome,

        String cpf,

        String email,

        String telefone,

        Integer idade,

        Materia materia,

        DadosEndereco endereco
) {
}
