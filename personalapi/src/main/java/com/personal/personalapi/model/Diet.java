package com.personal.personalapi.model;

import com.personal.personalapi.enums.DietGoal;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "diets")
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private DietGoal goal;

    private double dailyCalories;
    private double proteinGrams;
    private double carbGrams;
    private double fatGrams;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
