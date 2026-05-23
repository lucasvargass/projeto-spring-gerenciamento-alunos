package com.lucasvargasdev.gerenciamento_alunos.controller;

import com.lucasvargasdev.gerenciamento_alunos.model.Aluno;
import com.lucasvargasdev.gerenciamento_alunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public String inserirAluno(@RequestBody Aluno aluno){
        alunoService.criarAluno(aluno);
        return "Criado com sucesso!";
    }

    @PutMapping("/{id}")
    public String editarAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno){
        alunoService.atualizarAluno(id, aluno);
        return "Aluno editado com sucesso";
    }
}
