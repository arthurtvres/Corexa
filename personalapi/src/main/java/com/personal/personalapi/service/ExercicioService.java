package com.personal.personalapi.service;

import com.personal.personalapi.dto.ExercicioDTO;
import com.personal.personalapi.model.Exercicio;
import com.personal.personalapi.model.User;
import com.personal.personalapi.repository.ExercicioRepository;
import com.personal.personalapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {
    private final ExercicioRepository exercicioRepository;
    private final UserRepository userRepository;

    public ExercicioService(ExercicioRepository exercicioRepository, UserRepository userRepository) {
        this.exercicioRepository = exercicioRepository;
        this.userRepository = userRepository;
    }

    public List<Exercicio> listarExercicios() {
        return exercicioRepository.findAll();
    }

    public Exercicio salvarExercicio(ExercicioDTO exercicioDTO) {
        User user = userRepository.findById(exercicioDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Exercicio exercicio = new Exercicio();
        exercicio.setNome(exercicioDTO.getNome());
        exercicio.setDescricao(exercicioDTO.getDescricao());
        exercicio.setGifurl(exercicioDTO.getGifurl());
        exercicio.setAluno(user);
        return exercicioRepository.save(exercicio);
    }

    public Exercicio findExercicioById(Long id) {
        return exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
    }

    public Exercicio findExercicioByUserId(Long userId) {
        return exercicioRepository.findByAlunoId(userId)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado para o usuário " + userId));
    }

    public List<Exercicio> findAllExerciciosByUserId(Long userId) {
        return exercicioRepository.findAllByAlunoId(userId);
    }

    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }

}
