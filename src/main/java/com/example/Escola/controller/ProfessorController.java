package com.example.Escola.controller;


import com.example.Escola.domain.aluno.DadosListagemAluno;
import com.example.Escola.domain.professor.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("professor")
@SecurityRequirement(name = "bearer-key")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarProfessor(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBuilder) {
        var professor = new Professor(dados);
        repository.save(professor);

        var uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhementoProfessor(professor));
    }


    @GetMapping
    public ResponseEntity<List<DadosListagemProfessor>> listagemProfessor(){
        List<Professor> professores = repository.findAll();
        List<DadosListagemProfessor> dadosListagemProfessor = professores.stream()
                .map(DadosListagemProfessor::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dadosListagemProfessor);
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizarProfessor(@RequestBody @Valid DadosAtualizacaoProfessor dados){
        var professor = repository.getReferenceById(dados.id());
        professor.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhementoProfessor(professor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        repository.delete(professor);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity consultar(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhementoProfessor(professor));
    }


}
