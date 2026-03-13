package com.personal.personalapi.repository;

import com.personal.personalapi.enums.DietGoal;
import com.personal.personalapi.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {
    // User can have multiple diets, so return list
    List<Diet> findAllByUserId(Long userId);

    // Find first diet of a user
    Optional<Diet> findByUserId(Long userId);

    // Find diets by goal
    List<Diet> findByGoal(DietGoal goal);
}
