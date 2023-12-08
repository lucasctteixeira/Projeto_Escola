package com.example.Escola.domain.aula.validacoes;

import com.example.Escola.domain.ValidacaoException;
import com.example.Escola.domain.aula.DadosAgendamentoAula;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoAula implements ValidadorAgendamentoDeAulas {

    public void validar(DadosAgendamentoAula dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var sabado = dataConsulta.getDayOfWeek().equals(DayOfWeek.SATURDAY);

        var antesDaAberturaDaEscola = dataConsulta.getHour() < 8;
        var depoisDoEncerramentoDaEscola = dataConsulta.getHour() > 18;

        if (domingo || sabado || antesDaAberturaDaEscola || depoisDoEncerramentoDaEscola){
            throw new ValidacaoException("Aula fora do horário de funcionamento da escola!");
        }

    }


}
