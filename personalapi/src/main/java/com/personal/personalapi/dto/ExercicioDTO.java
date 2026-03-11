package com.personal.personalapi.dto;

import lombok.Data;

@Data
public class ExercicioDTO {
    private String nome;
    private String descricao;
    private int series;
    private int repeticoes;
    private Long treinoId;
}

