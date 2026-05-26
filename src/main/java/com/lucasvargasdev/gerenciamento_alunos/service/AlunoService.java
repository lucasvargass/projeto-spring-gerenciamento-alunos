package com.lucasvargasdev.gerenciamento_alunos.service;

import com.lucasvargasdev.gerenciamento_alunos.model.Aluno;
import com.lucasvargasdev.gerenciamento_alunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public void criarAluno(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public void atualizarAluno(Long id, Aluno aluno){
        Aluno alunoBanco = alunoRepository.findById(id).get();
        alunoBanco.setNome(aluno.getNome());
        alunoBanco.setDataNascimento(aluno.getDataNascimento());
        alunoBanco.setMatricula(aluno.getMatricula());
        alunoRepository.save(alunoBanco);
    }

    public void deletarAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()){
            System.out.println("Aluno não encontrado!");
        }else {
            alunoRepository.deleteById(id);
        }
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()){
            System.out.println("Aluno não encontrado!");
            return null;
        }
        return aluno.get();
    }
}
