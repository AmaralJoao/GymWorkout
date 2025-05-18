package com.joaoamaral.GymWorkout.Controller;

import com.joaoamaral.GymWorkout.Dto.Request.ExercicioRequestDto;
import com.joaoamaral.GymWorkout.Dto.Response.ExercicioResponseDto;
import com.joaoamaral.GymWorkout.Service.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/exercicios")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    @PostMapping("/novoexercicio")
    public ResponseEntity<ExercicioResponseDto> criarExercicio(@RequestBody ExercicioRequestDto exercicioRequestDto){

        ExercicioResponseDto responseDto = exercicioService.novoExercicio(exercicioRequestDto);

        return ResponseEntity
                .created(getLocationUri(responseDto.getIdExercicio()))
                .body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExercicioResponseDto> atualizarExercicio(
            @PathVariable Long id,
            @Valid @RequestBody ExercicioRequestDto exercicioRequestDto) {
        ExercicioResponseDto responseDto = exercicioService.atualizarExercicio(id, exercicioRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioResponseDto> buscarExercicioPorId(@PathVariable Long id) {
        ExercicioResponseDto responseDto = exercicioService.buscarExercicioPorId(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ExercicioResponseDto>> listarTodosExercicios() {
        List<ExercicioResponseDto> exercicios = exercicioService.listarTodosExercicios();
        return ResponseEntity.ok(exercicios);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ExercicioResponseDto>> listarExerciciosPorCategoria(
            @PathVariable String categoria) {
        List<ExercicioResponseDto> exercicios = exercicioService.listarExerciciosPorCategoria(categoria);
        return ResponseEntity.ok(exercicios);
    }

    private URI getLocationUri(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
