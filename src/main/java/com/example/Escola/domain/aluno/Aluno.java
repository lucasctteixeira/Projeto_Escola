package com.example.Escola.domain.aluno;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String email;
    private String cpf;
    private String telefone;
    private Integer idade;

    public Aluno(DadosCadastroAluno dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.idade = dados.idade();
    }


    public void atualizarInformacoes(DadosAtualizacaoAluno dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.cpf() != null){
            this.cpf = dados.cpf();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.idade() != null){
            this.idade = dados.idade();
        }
    }
}
