package com.example.Escola.domain.aula;

import java.time.LocalDateTime;

public record DadosDetalhamentoAula(Long id, Long idProfessor, Long idAluno, LocalDateTime data) {

    public DadosDetalhamentoAula(Aula aula){
        this(aula.getId(), aula.getProfessor().getId(), aula.getAluno().getId(), aula.getData());
    }

}
