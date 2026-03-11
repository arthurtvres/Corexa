package com.personal.personalapi.enums;

public enum ObjetivoDieta {

    PERDA_DE_PESO("Perda de peso"),
    GANHO_DE_MUSCULO("Ganho de músculo"),
    MANUTENCAO_DE_PESO("Manutenção de peso"),
    MELHORIA_DE_SAUDE("Melhoria de saúde"),
    AUMENTO_DE_ENERGIA("Aumento de energia");

    private final String descricao;

    ObjetivoDieta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ObjetivoDieta fromString(String value) {
        if (value == null) {
            return null;
        }
        String normalized = value
                .trim()
                .toUpperCase()
                .replace(" ", "_")
                .replace("Ç", "C")
                .replace("Ã", "A")
                .replace("Â", "A")
                .replace("Ê", "E")
                .replace("É", "E");
        for (ObjetivoDieta objetivo : values()) {
            if (objetivo.name().equals(normalized)) {
                return objetivo;
            }
        }
        throw new IllegalArgumentException("Objetivo de dieta inválido: " + value);
    }
}
