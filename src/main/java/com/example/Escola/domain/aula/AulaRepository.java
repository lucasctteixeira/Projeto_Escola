package com.example.Escola.domain.aula;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    boolean existsByProfessorIdAndData(Long idProfessor, LocalDateTime data);
}
