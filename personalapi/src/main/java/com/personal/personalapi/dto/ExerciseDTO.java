package com.personal.personalapi.dto;

import lombok.Data;

@Data
public class ExerciseDTO {
    private String name;
    private String description;
    private int sets;
    private int reps;
    private Long workoutId;
}
