package com.lucasvargasdev.gerenciamento_alunos.repository;

import com.lucasvargasdev.gerenciamento_alunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
