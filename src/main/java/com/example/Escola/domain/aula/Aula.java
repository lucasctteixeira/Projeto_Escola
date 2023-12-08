package com.example.Escola.domain.aula;


import com.example.Escola.domain.aluno.Aluno;
import com.example.Escola.domain.professor.Professor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "aulas")
@Entity(name = "Aula")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aula {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "idprofessor")
    @ManyToOne(fetch = FetchType.LAZY)
    private Professor professor;

    @JoinColumn(name = "idaluno")
    @ManyToOne(fetch = FetchType.LAZY)
    private Aluno aluno;


    private LocalDateTime data;

}
