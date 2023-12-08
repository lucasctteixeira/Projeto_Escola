package com.example.Escola.domain.professor;

import com.example.Escola.domain.endereco.Endereco;

public record DadosListagemProfessor(Long id, String nome, String cpf, String email, String telefone, Integer idade, Endereco endereco, Materia materia) {

    public DadosListagemProfessor(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getCpf(), professor.getEmail(), professor.getTelefone(), professor.getIdade(), professor.getEndereco(), professor.getMateria());
    }

}
