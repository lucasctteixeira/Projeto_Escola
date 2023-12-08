package com.example.Escola.domain.aula.validacoes;

import com.example.Escola.domain.ValidacaoException;
import com.example.Escola.domain.aula.DadosAgendamentoAula;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeAulas{

    public void validar(DadosAgendamentoAula dados){

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmDias = Duration.between(agora, dataConsulta).toDays();

        if(diferencaEmDias < 7){
            throw new ValidacaoException("Aula deve ser agendada com antecedencia minimo 7 dias");
        }

    }

}
