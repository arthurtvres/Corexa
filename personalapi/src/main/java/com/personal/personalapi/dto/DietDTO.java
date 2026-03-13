package com.personal.personalapi.dto;

import com.personal.personalapi.enums.DietGoal;
import lombok.Data;

@Data
public class DietDTO {

    private String name;
    private String description;
    private DietGoal goal;
    private double dailyCalories;
    private double proteinGrams;
    private double carbGrams;
    private double fatGrams;
    private Long userId;


}

