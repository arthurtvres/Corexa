package com.personal.personalapi.controller;

import com.personal.personalapi.dto.DietaDTO;
import com.personal.personalapi.model.Dieta;
import com.personal.personalapi.service.DietaService;
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
    public Dieta criarDieta(@RequestBody DietaDTO dietaDTO) {
        return dietaService.salvarDieta(dietaDTO);
    }

    @GetMapping
    public List<Dieta> listarDieta() {
        return dietaService.listarDietas();
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

    @DeleteMapping
    public void deletarDieta(@RequestParam Long id) {
        dietaService.deletarDieta(id);
    }
}
