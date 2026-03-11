package com.personal.personalapi.service;

import com.personal.personalapi.dto.ExercicioDTO;
import com.personal.personalapi.model.Exercicio;
import com.personal.personalapi.model.Treino;
import com.personal.personalapi.repository.ExercicioRepository;
import com.personal.personalapi.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {
    private final ExercicioRepository exercicioRepository;
    private final TreinoRepository treinoRepository;

    public ExercicioService(ExercicioRepository exercicioRepository, TreinoRepository treinoRepository) {
        this.exercicioRepository = exercicioRepository;
        this.treinoRepository = treinoRepository;
    }

    public List<Exercicio> listarExercicios() {
        return exercicioRepository.findAll();
    }

    public Exercicio salvarExercicio(ExercicioDTO exercicioDTO) {
        Treino treino = treinoRepository.findById(exercicioDTO.getTreinoId())
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        Exercicio exercicio = new Exercicio();
        exercicio.setNome(exercicioDTO.getNome());
        exercicio.setDescricao(exercicioDTO.getDescricao());
        exercicio.setSeries(exercicioDTO.getSeries());
        exercicio.setRepeticoes(exercicioDTO.getRepeticoes());
        exercicio.setTreino(treino);

        return exercicioRepository.save(exercicio);
    }

    public Exercicio atualizarExercicio(Long id, ExercicioDTO exercicioDTO) {
        Exercicio exercicio = exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));

        Treino treino = treinoRepository.findById(exercicioDTO.getTreinoId())
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        exercicio.setNome(exercicioDTO.getNome());
        exercicio.setDescricao(exercicioDTO.getDescricao());
        exercicio.setSeries(exercicioDTO.getSeries());
        exercicio.setRepeticoes(exercicioDTO.getRepeticoes());
        exercicio.setTreino(treino);

        return exercicioRepository.save(exercicio);
    }

    public Exercicio findExercicioById(Long id) {
        return exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
    }

    public List<Exercicio> findAllExerciciosByTreinoId(Long treinoId) {
        return exercicioRepository.findAllByTreinoId(treinoId);
    }

    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }

}
