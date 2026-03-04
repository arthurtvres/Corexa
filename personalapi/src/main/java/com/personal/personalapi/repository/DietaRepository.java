package com.personal.personalapi.repository;

import com.personal.personalapi.model.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface DietaRepository extends JpaRepository<Dieta, Long> {
    Optional<Dieta> findByAlunoId(Long alunoId);

    //Usuario pode ter várias dietas, então o retorno deve ser uma lista
    List<Dieta> findAllByAlunoId(Long alunoId);
}
