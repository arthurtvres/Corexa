package com.personal.personalapi.repository;

import com.personal.personalapi.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
    Optional<Treino> findByAlunoId(Long alunoId);

    List<Treino> findAllByAlunoId(Long alunoId);
}
