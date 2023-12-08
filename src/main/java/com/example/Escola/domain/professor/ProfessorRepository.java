package com.example.Escola.domain.professor;

import com.example.Escola.domain.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("""
            select m from Professor m 
            where
            m.materia = :materia
            and
            m.id not in(
                select c.professor.id from Aula c
                where
                c.data = :data
            )
            order by random()
            limit 1
            """)
    Professor escolherProfessorAleatorioLivreNaData(Materia materia, LocalDateTime data);
}
