package com.personal.personalapi.dto;

import lombok.Data;

@Data
public class WorkoutDTO {
    private String name;
    private String description;
    private Long userId;
}
