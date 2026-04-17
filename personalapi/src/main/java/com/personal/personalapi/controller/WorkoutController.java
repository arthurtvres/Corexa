package com.personal.personalapi.controller;

import com.personal.personalapi.dto.WorkoutDTO;
import com.personal.personalapi.model.Workout;
import com.personal.personalapi.service.AuthorizationService;
import com.personal.personalapi.service.WorkoutService;
import com.personal.personalapi.exception.BusinessException;
import com.personal.personalapi.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;
    private final AuthorizationService authorizationService;

    public WorkoutController(WorkoutService workoutService, AuthorizationService authorizationService) {
        this.workoutService = workoutService;
        this.authorizationService = authorizationService;
    }

    @PostMapping
    public ResponseEntity<Workout> create(@Valid  @RequestBody WorkoutDTO workoutDTO) {
        Workout workout = workoutService.save(workoutDTO);
        return ResponseEntity.status(201).body(workout);
    }

    @GetMapping
    public List<Workout> list() {
        return workoutService.listAll();
    }

    @GetMapping("/{id}")
    public Workout findById(@PathVariable Long id) {
        return workoutService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Workout> findAllByUserId(@PathVariable Long userId, @AuthenticationPrincipal User loggedUser) {
        authorizationService.checkUserAccess(loggedUser, userId);

        return workoutService.findAllByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workoutService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
