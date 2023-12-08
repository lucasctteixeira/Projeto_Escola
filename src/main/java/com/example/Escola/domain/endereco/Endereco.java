package com.example.Escola.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String cidade;

    private String rua;
    private String bairro;
    private String cep;
    private Integer numero;
    private String complemento;

    public Endereco(DadosEndereco dados) {
        this.cidade = dados.cidade();
        this.rua = dados.rua();
        this.cep = dados.cep();
        this.bairro = dados.bairro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }


}
