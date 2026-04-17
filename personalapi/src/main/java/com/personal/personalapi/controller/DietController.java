package com.personal.personalapi.controller;

import com.personal.personalapi.dto.DietDTO;
import com.personal.personalapi.dto.DietResponseDTO;
import com.personal.personalapi.model.Diet;
import com.personal.personalapi.service.AuthorizationService;
import com.personal.personalapi.service.DietService;
import com.personal.personalapi.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diets")
public class DietController {

    private final DietService dietService;
    private final AuthorizationService authorizationService;

    public DietController(DietService dietService, AuthorizationService authorizationService) {
        this.dietService = dietService;
        this.authorizationService = authorizationService;
    }

    @PostMapping
    public ResponseEntity<Diet> create(@Valid @RequestBody DietDTO dietDTO) {
        Diet diet = dietService.save(dietDTO);
        return ResponseEntity.status(201).body(diet);
    }

    @GetMapping
    public List<DietResponseDTO> list() {
        return dietService.listAll();
    }

    @GetMapping("/{id}")
    public DietResponseDTO findById(@PathVariable Long id) {
        return dietService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public DietResponseDTO findByUserId(@PathVariable Long userId, @AuthenticationPrincipal User loggedUser) {
        authorizationService.checkUserAccess(loggedUser, userId);

        return dietService.findByUserId(userId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diet> update(@PathVariable Long id, @Valid @RequestBody DietDTO dietDTO) {
        Diet diet = dietService.update(id, dietDTO);

        return ResponseEntity.ok(diet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dietService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
