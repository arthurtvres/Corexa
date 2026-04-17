package com.personal.personalapi.controller;

import com.personal.personalapi.dto.UserDTO;
import com.personal.personalapi.exception.BusinessException;
import com.personal.personalapi.model.User;
import com.personal.personalapi.service.AuthorizationService;
import com.personal.personalapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    private final UserService userService;
    private final AuthorizationService authorizationService;

    public UserController(UserService userService, AuthorizationService authorizationService) {
        this.userService = userService;
        this.authorizationService = authorizationService;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping
    public List<User> getAllUsers(@AuthenticationPrincipal User loggedUser) {
        authorizationService.checkIsPersonal(loggedUser);

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id, @AuthenticationPrincipal User loggedUser) {
        authorizationService.checkUserAccess(loggedUser, id);

        return userService.findUserById(id);
    }

    @GetMapping("/me")
    public User getLoggedUser(@AuthenticationPrincipal User loggedUser) {
        return loggedUser;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
