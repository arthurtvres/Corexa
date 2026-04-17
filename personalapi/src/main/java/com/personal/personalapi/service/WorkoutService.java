package com.personal.personalapi.service;

import com.personal.personalapi.dto.WorkoutDTO;
import com.personal.personalapi.dto.WorkoutResponseDTO;
import com.personal.personalapi.exception.ResourceNotFoundException;
import com.personal.personalapi.model.Workout;
import com.personal.personalapi.model.User;
import com.personal.personalapi.repository.WorkoutRepository;
import com.personal.personalapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;

    public WorkoutService(WorkoutRepository workoutRepository, UserRepository userRepository) {
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
    }

    public List<WorkoutResponseDTO> listAll() {
        return workoutRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public Workout save(WorkoutDTO workoutDTO) {
        User user = userRepository.findById(workoutDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado"));

        Workout workout = new Workout();
        workout.setName(workoutDTO.getName());
        workout.setDescription(workoutDTO.getDescription());
        workout.setUser(user);

        return workoutRepository.save(workout);
    }

    public WorkoutResponseDTO findById(Long id) {
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treino nao encontrado"));

        return toResponseDto(workout);
    }

    public List<WorkoutResponseDTO> findAllByUserId(Long userId) {
        return workoutRepository.findAllByUserId(userId)
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public void delete(Long id) {
        workoutRepository.deleteById(id);
    }

    private WorkoutResponseDTO toResponseDto(Workout workout) {
        return new WorkoutResponseDTO(
                workout.getId(),
                workout.getName(),
                workout.getDescription(),
                workout.getUser() != null ? workout.getUser().getId() : null
        );
    }
}
