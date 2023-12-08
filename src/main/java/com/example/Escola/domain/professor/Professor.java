package com.example.Escola.domain.professor;


import com.example.Escola.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "professores")
@Entity(name = "Professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Integer idade;

    @Embedded
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private Materia materia;


    public Professor(DadosCadastroProfessor dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.idade = dados.idade();
        this.materia = dados.materia();
        this.endereco = new Endereco(dados.endereco());
    }


    public void atualizarInformacoes(DadosAtualizacaoProfessor dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.idade = dados.idade();
        this.materia = dados.materia();
        this.endereco = new Endereco(dados.endereco());
    }
}
