package com.example.Escola.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String cidade,
        @NotBlank
        String rua,
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String bairro,
        @NotNull
        Integer numero,
        String complemento) {
}
