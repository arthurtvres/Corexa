package com.personal.personalapi.repository;

import com.personal.personalapi.enums.DietGoal;
import com.personal.personalapi.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {
    boolean existsByUserId(Long userId);

    List<Diet> findAllByUserId(Long userId);
    Optional<Diet> findByUserId(Long userId);
    List<Diet> findByGoal(DietGoal goal);
}
