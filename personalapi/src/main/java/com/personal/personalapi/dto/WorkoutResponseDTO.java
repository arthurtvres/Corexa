package com.personal.personalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorkoutResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Long userId;
}