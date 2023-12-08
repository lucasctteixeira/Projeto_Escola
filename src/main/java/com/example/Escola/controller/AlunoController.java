package com.example.Escola.controller;

import com.example.Escola.domain.aluno.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("aluno")
@SecurityRequirement(name = "bearer-key")
public class AlunoController {


    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarAluno(@RequestBody @Valid DadosCadastroAluno dados){
        var aluno = new Aluno(dados);
        repository.save(aluno);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemAluno>> listaDeAlunos(){
        List<Aluno> alunos = repository.findAll();
        List<DadosListagemAluno> dadosListagemAlunos = alunos.stream()
                .map(DadosListagemAluno::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dadosListagemAlunos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarAluno(@RequestBody @Valid DadosAtualizacaoAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @DeleteMapping("/{matricula}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long matricula){
        var aluno = repository.getReferenceById(matricula);
        repository.delete(aluno);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity detalhar(@PathVariable Long matricula){
        var aluno = repository.getReferenceById(matricula);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }


}
