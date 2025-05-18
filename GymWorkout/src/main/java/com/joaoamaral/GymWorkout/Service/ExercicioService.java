package com.joaoamaral.GymWorkout.Service;

import com.joaoamaral.GymWorkout.Dto.Request.ExercicioRequestDto;
import com.joaoamaral.GymWorkout.Dto.Response.ExercicioResponseDto;
import com.joaoamaral.GymWorkout.Mapper.ExercicioMapper;
import com.joaoamaral.GymWorkout.Model.ExercicioModel;
import com.joaoamaral.GymWorkout.Repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;
    @Autowired
    private ExercicioMapper exercicioMapper;

    public ExercicioResponseDto novoExercicio(ExercicioRequestDto exercicioRequestDto){

        if (exercicioRequestDto == null){
            throw new RuntimeException("exercicioDto não pode ser vazio");
        }

        ExercicioModel exercicioModel = exercicioMapper.requestToModel(exercicioRequestDto);
        ExercicioModel salvarExercicio = exercicioRepository.save(exercicioModel);

        return exercicioMapper.toDto(salvarExercicio);
    }

    public ExercicioResponseDto atualizarExercicio(Long id, ExercicioRequestDto exercicioRequestDto) {
        Objects.requireNonNull(exercicioRequestDto, "O DTO de exercício não pode ser nulo");

        ExercicioModel exercicioModel = exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado com id: " + id));

        exercicioMapper.updateModelFromDto(exercicioRequestDto, exercicioModel);
        // Não precisa de save explícito se estiver dentro de uma transação (@Transactional)

        return exercicioMapper.toDto(exercicioModel);
    }

    public ExercicioResponseDto buscarExercicioPorId(Long id) {
        ExercicioModel exercicioModel = exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado com id: " + id));

        return exercicioMapper.toDto(exercicioModel);
    }

    public List<ExercicioResponseDto> listarTodosExercicios() {
        return exercicioRepository.findAll()
                .stream()
                .map(exercicioMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ExercicioResponseDto> listarExerciciosPorCategoria(String categoria) {
        return exercicioRepository.findByCategoria(categoria)
                .stream()
                .map(exercicioMapper::toDto)
                .collect(Collectors.toList());
    }
}
