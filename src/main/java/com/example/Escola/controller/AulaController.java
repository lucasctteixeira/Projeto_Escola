package com.example.Escola.controller;

import com.example.Escola.domain.aluno.DadosDetalhamentoAluno;
import com.example.Escola.domain.aula.AgendaDeAulas;
import com.example.Escola.domain.aula.Aula;
import com.example.Escola.domain.aula.DadosAgendamentoAula;
import com.example.Escola.domain.aula.DadosDetalhamentoAula;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aulas")
@SecurityRequirement(name = "bearer-key")
public class AulaController {

    @Autowired
    private AgendaDeAulas agenda;


    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoAula dados){
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }


}
