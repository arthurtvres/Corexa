package com.personal.personalapi.repository;

import com.personal.personalapi.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findAllByWorkoutId(Long workoutId);
}
