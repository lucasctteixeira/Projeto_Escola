package com.example.Escola.domain.aula;

import com.example.Escola.domain.professor.Materia;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoAula(

        Long idProfessor,

        @NotNull
        Long idAluno,

        @Future
        @NotNull
        LocalDateTime data,

        Materia materia

) {
}
