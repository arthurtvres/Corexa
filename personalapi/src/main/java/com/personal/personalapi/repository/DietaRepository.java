package com.personal.personalapi.repository;

import com.personal.personalapi.enums.ObjetivoDieta;
import com.personal.personalapi.model.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface DietaRepository extends JpaRepository<Dieta, Long> {
    //Usuario pode ter várias dietas, então o retorno deve ser uma lista
    List<Dieta> findAllByAlunoId(Long alunoId);

    // Busca a primeira dieta de um aluno
    Optional<Dieta> findByAlunoId(Long alunoId);

    // Busca dietas por objetivo.
    List<Dieta> findByObjetivo(ObjetivoDieta objetivo);
}
