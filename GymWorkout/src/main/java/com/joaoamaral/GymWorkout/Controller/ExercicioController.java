package com.joaoamaral.GymWorkout.Controller;

import com.joaoamaral.GymWorkout.Dto.Request.ExercicioRequestDto;
import com.joaoamaral.GymWorkout.Dto.Response.ExercicioResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/exercicio")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    @PostMapping("/novoexercicio")
    public ResponseEntity<ExercicioResponseDto> criarExercicio(ExercicioRequestDto exercicioRequestDto){


    }

}
