package com.personal.personalapi.service;

import com.personal.personalapi.dto.DietDTO;
import com.personal.personalapi.model.Diet;
import com.personal.personalapi.model.User;
import com.personal.personalapi.repository.DietRepository;
import com.personal.personalapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietService {
    private final DietRepository dietRepository;
    private final UserRepository userRepository;

    public DietService(DietRepository dietRepository, UserRepository userRepository) {
        this.dietRepository = dietRepository;
        this.userRepository = userRepository;
    }

    public List<Diet> listAll() {
        return dietRepository.findAll();
    }

    public Diet save(DietDTO dietDTO) {
        User user = userRepository.findById(dietDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Diet diet = new Diet();
        diet.setName(dietDTO.getName());
        diet.setDescription(dietDTO.getDescription());
        diet.setGoal(dietDTO.getGoal());
        diet.setDailyCalories(dietDTO.getDailyCalories());
        diet.setProteinGrams(dietDTO.getProteinGrams());
        diet.setCarbGrams(dietDTO.getCarbGrams());
        diet.setFatGrams(dietDTO.getFatGrams());
        diet.setUser(user);

        return dietRepository.save(diet);
    }

    public Diet update(Long id, DietDTO dietDTO) {
        Diet diet = dietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diet not found"));

        User user = userRepository.findById(dietDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        diet.setName(dietDTO.getName());
        diet.setDescription(dietDTO.getDescription());
        diet.setGoal(dietDTO.getGoal());
        diet.setDailyCalories(dietDTO.getDailyCalories());
        diet.setProteinGrams(dietDTO.getProteinGrams());
        diet.setCarbGrams(dietDTO.getCarbGrams());
        diet.setFatGrams(dietDTO.getFatGrams());
        diet.setUser(user);

        return dietRepository.save(diet);
    }

    public Diet findById(Long id) {
        return dietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diet not found"));
    }

    public Diet findByUserId(Long userId) {
        return dietRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Diet not found for user " + userId));
    }

    public List<Diet> findAllByUserId(Long userId) {
        return dietRepository.findAllByUserId(userId);
    }

    public void delete(Long id) {
        dietRepository.deleteById(id);
    }
}
