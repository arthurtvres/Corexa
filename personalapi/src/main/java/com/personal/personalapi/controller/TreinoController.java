package com.personal.personalapi.controller;

import com.personal.personalapi.dto.TreinoDTO;
import com.personal.personalapi.model.Treino;
import com.personal.personalapi.service.TreinoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treino")
public class TreinoController {
    private final TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @PostMapping
    public Treino criarTreino(@RequestBody TreinoDTO treinoDTO) {
        return treinoService.salvarTreino(treinoDTO);
    }

    @GetMapping
    public List<Treino> listarTreino() {
        return treinoService.listarTreinos();
    }

    @GetMapping("/{id}")
    public Treino findTreinoById(@PathVariable Long id) {
        return treinoService.findTreinoById(id);
    }

    @GetMapping("/usuario/{userId}/todos")
    public List<Treino> findAllTreinosByUserId(@PathVariable Long userId) {
        return treinoService.findAllTreinosByUserId(userId);
    }

    @DeleteMapping
    public void deleteTreino(@RequestParam Long id) {
        treinoService.deleteTreino(id);
    }
}
