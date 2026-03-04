package com.personal.personalapi.controller;

import com.personal.personalapi.dto.UserDTO;
import com.personal.personalapi.model.User;
import com.personal.personalapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User criar(@RequestBody UserDTO userDTO) {
        return userService.salvarUsuario(userDTO);
    }

    @GetMapping("/{id}")
    public User findAlunoById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public List<User> listAllAlunos() {
        return userService.listarUsuarios();
    }

    @DeleteMapping
    public void deletarUsuario(@RequestParam Long id) {
        userService.deletarUsuario(id);
    }

}
