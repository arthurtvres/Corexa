package com.personal.personalapi.controller;

import com.personal.personalapi.dto.DietaDTO;
import com.personal.personalapi.model.Dieta;
import com.personal.personalapi.service.DietaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dieta")
public class DietaController {

    private final DietaService dietaService;

    public DietaController(DietaService dietaService) {
        this.dietaService = dietaService;
    }

    @PostMapping
    public ResponseEntity<Dieta> criarDieta(@RequestBody DietaDTO dietaDTO) {
        Dieta dieta = dietaService.salvarDieta(dietaDTO);
        return ResponseEntity.status(201).body(dieta); // 201 Created
    }

    @GetMapping
    public List<Dieta> listarDietas() {
        return dietaService.listarDietas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dieta> atualizarDieta(@PathVariable Long id, @RequestBody DietaDTO dietaDTO) {
        Dieta dieta = dietaService.atualizarDieta(id, dietaDTO);
        return ResponseEntity.ok(dieta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDieta(@PathVariable Long id) {
        dietaService.deletarDieta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Dieta findDietaById(@PathVariable Long id) {

        return dietaService.findDietaById(id);
    }

    @GetMapping("/usuario/{userId}")
    public Dieta findDietaByUserId(@PathVariable Long userId) {

        return dietaService.findDietaByUserId(userId);
    }

    @GetMapping("/usuario/{userId}/todas")
    public List<Dieta> findAllDietasByUserId(@PathVariable Long userId) {
        return dietaService.findAllDietasByUserId(userId);
    }
}
