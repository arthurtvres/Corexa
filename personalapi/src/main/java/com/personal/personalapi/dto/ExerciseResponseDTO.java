package com.personal.personalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExerciseResponseDTO {
    private Long id;
    private String name;
    private String description;
    private int sets;
    private int reps;
    private Long workoutId;
}
