package com.lucasvargasdev.gerenciamento_alunos.controller;

import com.lucasvargasdev.gerenciamento_alunos.model.Aluno;
import com.lucasvargasdev.gerenciamento_alunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> buscarAlunos(){
        List<Aluno> alunos = alunoService.getAllAlunos();
        return alunos;
    }
}
