package com.example.Escola.domain.aula;

import com.example.Escola.domain.aluno.AlunoRepository;
import com.example.Escola.domain.aula.validacoes.ValidadorAgendamentoDeAulas;
import com.example.Escola.domain.professor.Professor;
import com.example.Escola.domain.professor.ProfessorRepository;
import com.example.Escola.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeAulas {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private List<ValidadorAgendamentoDeAulas> validadores;

    public DadosDetalhamentoAula agendar(DadosAgendamentoAula dados) throws ValidacaoException {

        if (!alunoRepository.existsById(dados.idAluno())){
            throw new ValidacaoException("O Id do aluno informado não existe!");
        }

        if (dados.idProfessor() != null && !professorRepository.existsById(dados.idProfessor())){
            throw new ValidacaoException("O Id do professor informado não existe!");
        }

        validadores.forEach(v -> v.validar(dados));

        var aluno = alunoRepository.getReferenceById(dados.idAluno());
        var professor = escolherProfessor(dados);
        var aula = new Aula(null, professor, aluno, dados.data());
        aulaRepository.save(aula);

        return new DadosDetalhamentoAula(aula);
    }

    private Professor escolherProfessor(DadosAgendamentoAula dados) {
        if (dados.idProfessor() != null){
            return professorRepository.getReferenceById(dados.idProfessor());
        }
        if (dados.materia() == null){
            throw new ValidacaoException("Materia é obrigatório quando o professor não for escolhido!");
        }

        return professorRepository.escolherProfessorAleatorioLivreNaData(dados.materia(), dados.data());

    }


}
