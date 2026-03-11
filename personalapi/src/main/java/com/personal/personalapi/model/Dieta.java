package com.personal.personalapi.model;

import com.personal.personalapi.enums.ObjetivoDieta;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "dietas")
public class Dieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private ObjetivoDieta objetivo;

    private double caloriasDiarias;
    private double proteinasGramas;
    private double carboidratosGramas;
    private double gordurasGramas;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User aluno;

}
