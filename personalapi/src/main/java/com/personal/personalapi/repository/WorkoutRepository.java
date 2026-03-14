package com.personal.personalapi.repository;

import com.personal.personalapi.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    boolean existsByUserId(Long userId);

    Optional<Workout> findByUserId(Long userId);
    List<Workout> findAllByUserId(Long userId);

}
