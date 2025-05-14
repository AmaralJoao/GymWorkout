package com.joaoamaral.GymWorkout.Service;

import com.joaoamaral.GymWorkout.Dto.Request.ExercicioRequestDto;
import com.joaoamaral.GymWorkout.Dto.Response.ExercicioResponseDto;
import com.joaoamaral.GymWorkout.Model.ExercicioModel;
import com.joaoamaral.GymWorkout.Repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    public ExercicioResponseDto novoExercicio(ExercicioRequestDto exercicioRequestDto){

        ExercicioModel exercicioModel = new ExercicioModel();
        exercicioModel.setNomeExercicio(exercicioRequestDto.getNomeDoExercicio());
        exercicioModel.setDescricao(exercicioRequestDto.getDescricaoExercicio());
        exercicioModel.setCategoria(exercicioRequestDto.getCategoria());

        ExercicioResponseDto exercicio = exercicioRepository.save(exercicioModel);
        return exercicio;
    }
}
