package com.personal.personalapi.dto;

import com.personal.personalapi.enums.ObjetivoDieta;
import lombok.Data;

@Data
public class DietaDTO {

    private String nome;
    private String descricao;
    private ObjetivoDieta objetivo;
    private double caloriasDiarias;
    private double proteinasGramas;
    private double carboidratosGramas;
    private double gordurasGramas;
    private Long userId;




}

