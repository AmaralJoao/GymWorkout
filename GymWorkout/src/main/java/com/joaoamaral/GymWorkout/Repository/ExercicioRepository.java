package com.joaoamaral.GymWorkout.Repository;

import com.joaoamaral.GymWorkout.Model.ExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<ExercicioModel, Long> {
}
