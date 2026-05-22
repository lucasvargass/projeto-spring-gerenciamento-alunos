package com.lucasvargasdev.gerenciamento_alunos.service;

import com.lucasvargasdev.gerenciamento_alunos.model.Aluno;
import com.lucasvargasdev.gerenciamento_alunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }
}
