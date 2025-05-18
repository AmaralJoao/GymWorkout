package com.joaoamaral.GymWorkout.Mapper;

import com.joaoamaral.GymWorkout.Dto.Request.ExercicioRequestDto;
import com.joaoamaral.GymWorkout.Dto.Response.ExercicioResponseDto;
import com.joaoamaral.GymWorkout.Model.ExercicioModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-15T13:21:19-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class ExercicioMapperImpl implements ExercicioMapper {

    @Override
    public ExercicioModel requestToModel(ExercicioRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ExercicioModel exercicioModel = new ExercicioModel();

        exercicioModel.setNomeExercicio( dto.getNomeDoExercicio() );
        exercicioModel.setDescricao( dto.getDescricaoExercicio() );
        exercicioModel.setCategoria( dto.getCategoria() );

        return exercicioModel;
    }

    @Override
    public ExercicioResponseDto toDto(ExercicioModel model) {
        if ( model == null ) {
            return null;
        }

        ExercicioResponseDto exercicioResponseDto = new ExercicioResponseDto();

        exercicioResponseDto.setNomeDoExercicio( model.getNomeExercicio() );
        exercicioResponseDto.setDescricaoExercicio( model.getDescricao() );
        exercicioResponseDto.setCategoria( model.getCategoria() );

        return exercicioResponseDto;
    }

    @Override
    public void updateModelFromDto(ExercicioRequestDto dto, ExercicioModel model) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getNomeDoExercicio() != null ) {
            model.setNomeExercicio( dto.getNomeDoExercicio() );
        }
        if ( dto.getDescricaoExercicio() != null ) {
            model.setDescricao( dto.getDescricaoExercicio() );
        }
        if ( dto.getCategoria() != null ) {
            model.setCategoria( dto.getCategoria() );
        }
    }
}
