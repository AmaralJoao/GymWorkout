package com.joaoamaral.GymWorkout.Repository;

import com.joaoamaral.GymWorkout.Model.ExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioModel, Long> {

    List<ExercicioModel> findByCategoria(String categoria);

    List<ExercicioModel> findByCategoriaIgnoreCase(String categoria);

    boolean existsByNomeExercicio(String nomeExercicio);

    List<ExercicioModel> findByNomeExercicioContainingIgnoreCase(String termo);
}
