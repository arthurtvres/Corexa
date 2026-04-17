package com.personal.personalapi.service;

import com.personal.personalapi.dto.ExerciseDTO;
import com.personal.personalapi.dto.ExerciseResponseDTO;
import com.personal.personalapi.exception.ResourceNotFoundException;
import com.personal.personalapi.model.Exercise;
import com.personal.personalapi.model.Workout;
import com.personal.personalapi.repository.ExerciseRepository;
import com.personal.personalapi.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final WorkoutRepository workoutRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, WorkoutRepository workoutRepository) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }

    public List<ExerciseResponseDTO> listAll() {
        return exerciseRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public Exercise save(ExerciseDTO exerciseDTO) {
        Workout workout = workoutRepository.findById(exerciseDTO.getWorkoutId())
                .orElseThrow(() -> new ResourceNotFoundException("Treino nao encontrado"));

        Exercise exercise = new Exercise();
        exercise.setName(exerciseDTO.getName());
        exercise.setDescription(exerciseDTO.getDescription());
        exercise.setSets(exerciseDTO.getSets());
        exercise.setReps(exerciseDTO.getReps());
        exercise.setWorkout(workout);

        return exerciseRepository.save(exercise);
    }

    public Exercise update(Long id, ExerciseDTO exerciseDTO) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercicio nao encontrado"));

        Workout workout = workoutRepository.findById(exerciseDTO.getWorkoutId())
                .orElseThrow(() -> new ResourceNotFoundException("Treino nao encontrado"));

        exercise.setName(exerciseDTO.getName());
        exercise.setDescription(exerciseDTO.getDescription());
        exercise.setSets(exerciseDTO.getSets());
        exercise.setReps(exerciseDTO.getReps());
        exercise.setWorkout(workout);

        return exerciseRepository.save(exercise);
    }

    public ExerciseResponseDTO findById(Long id) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercicio nao encontrado"));

        return toResponseDto(exercise);
    }

    public List<ExerciseResponseDTO> findAllByWorkoutId(Long workoutId) {
        return exerciseRepository.findAllByWorkoutId(workoutId)
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public void delete(Long id) {
        exerciseRepository.deleteById(id);
    }

    private ExerciseResponseDTO toResponseDto(Exercise exercise) {
        return new ExerciseResponseDTO(
                exercise.getId(),
                exercise.getName(),
                exercise.getDescription(),
                exercise.getSets(),
                exercise.getReps(),
                exercise.getWorkout() != null ? exercise.getWorkout().getId() : null
        );
    }
}
