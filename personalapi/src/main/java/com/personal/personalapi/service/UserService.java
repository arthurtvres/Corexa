package com.personal.personalapi.service;

import com.personal.personalapi.dto.UserDTO;
import com.personal.personalapi.model.User;
import com.personal.personalapi.repository.DietRepository;
import com.personal.personalapi.repository.UserRepository;
import com.personal.personalapi.repository.WorkoutRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final WorkoutRepository workoutRepository;
    private final DietRepository dietRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, WorkoutRepository workoutRepository, DietRepository dietRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.workoutRepository = workoutRepository;
        this.dietRepository = dietRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole());
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deleteUser(Long id) {
        System.out.println("Entrou no deleteUser");

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        boolean hasWorkouts = workoutRepository.existsByUserId(id);
        boolean hasDiets = dietRepository.existsByUserId(id);

        if (hasWorkouts || hasDiets) {
            System.out.println("Usuário possui treinos ou dietas associadas, não é possível excluir.");
            throw new RuntimeException("Não é possível excluir o usuário, pois ele possui treinos ou dietas associadas.");
        }

        userRepository.deleteById(id);
    }



}
