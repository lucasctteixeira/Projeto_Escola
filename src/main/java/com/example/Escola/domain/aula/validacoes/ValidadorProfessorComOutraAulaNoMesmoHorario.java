package com.example.Escola.domain.aula.validacoes;

import com.example.Escola.domain.ValidacaoException;
import com.example.Escola.domain.aula.AulaRepository;
import com.example.Escola.domain.aula.DadosAgendamentoAula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorProfessorComOutraAulaNoMesmoHorario implements ValidadorAgendamentoDeAulas {

    @Autowired
    private AulaRepository repository;

    public void validar(DadosAgendamentoAula dados){
        var professorPossuiOutraAulaNoMesmoHorario = repository.existsByProfessorIdAndData(dados.idProfessor(), dados.data());
        if (professorPossuiOutraAulaNoMesmoHorario){
            throw new ValidacaoException("Professor já possui outra aula agendada nesse mesmo horário!");
        }
    }


}
