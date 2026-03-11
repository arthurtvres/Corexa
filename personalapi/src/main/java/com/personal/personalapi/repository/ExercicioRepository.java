package com.personal.personalapi.repository;

import com.personal.personalapi.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    List<Exercicio> findAllByTreinoId(Long treinoId);
}
