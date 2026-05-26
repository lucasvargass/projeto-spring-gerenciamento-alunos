package com.lucasvargasdev.gerenciamento_alunos.controller;

import com.lucasvargasdev.gerenciamento_alunos.model.Aluno;
import com.lucasvargasdev.gerenciamento_alunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarAlunos(){
        List<Aluno> alunos = alunoService.getAllAlunos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id){
        Aluno aluno = alunoService.getAlunoById(id);
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<String> inserirAluno(@RequestBody Aluno aluno){
        Long id = alunoService.criarAluno(aluno);
        try {
            URI location = new URI("https://localhost:8080/aluno/" + id);
            return ResponseEntity.created(location).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno){
        alunoService.atualizarAluno(id, aluno);
        return ResponseEntity.ok("Aluno editado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirAluno(@PathVariable("id") Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.ok("Aluno deletado com sucesso!");
    }
}
