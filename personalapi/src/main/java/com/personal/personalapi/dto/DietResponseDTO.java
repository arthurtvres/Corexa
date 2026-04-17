package com.personal.personalapi.dto;

import com.personal.personalapi.enums.DietGoal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DietResponseDTO {
    private Long id;
    private String name;
    private String description;
    private DietGoal goal;
    private double dailyCalories;
    private double proteinGrams;
    private double carbGrams;
    private double fatGrams;
    private Long userId;
}
