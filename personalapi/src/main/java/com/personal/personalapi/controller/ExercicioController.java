package com.personal.personalapi.controller;

import com.personal.personalapi.dto.ExercicioDTO;
import com.personal.personalapi.model.Exercicio;
import com.personal.personalapi.service.ExercicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping
    public ResponseEntity<Exercicio> criarExercicio(@RequestBody ExercicioDTO exercicioDTO) {
        Exercicio exercicio = exercicioService.salvarExercicio(exercicioDTO);
        return ResponseEntity.status(201).body(exercicio);
    }

    @GetMapping
    public List<Exercicio> listarExercicios() {
        return exercicioService.listarExercicios();
    }

    @GetMapping("/{id}")
    public Exercicio findExercicioById(@PathVariable Long id) {
        return exercicioService.findExercicioById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizarExercicio(@PathVariable Long id, @RequestBody ExercicioDTO exercicioDTO) {
        Exercicio exercicio = exercicioService.atualizarExercicio(id, exercicioDTO);
        return ResponseEntity.ok(exercicio);
    }

    @GetMapping("/treino/{treinoId}")
    public List<Exercicio> findAllExerciciosByTreinoId(@PathVariable Long treinoId) {
        return exercicioService.findAllExerciciosByTreinoId(treinoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExercicio(@PathVariable Long id) {
        exercicioService.deletarExercicio(id);
        return ResponseEntity.noContent().build();
    }
}

