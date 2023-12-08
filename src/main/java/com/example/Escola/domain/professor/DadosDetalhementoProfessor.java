package com.example.Escola.domain.professor;

import com.example.Escola.domain.endereco.DadosEndereco;
import com.example.Escola.domain.endereco.Endereco;

public record DadosDetalhementoProfessor(Long id, String nome, String cpf, String email, String telefone, Integer idade, Materia materia, Endereco endereco) {

    public DadosDetalhementoProfessor(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getCpf(), professor.getEmail(), professor.getTelefone(), professor.getIdade(), professor.getMateria(), professor.getEndereco());
    }
}
