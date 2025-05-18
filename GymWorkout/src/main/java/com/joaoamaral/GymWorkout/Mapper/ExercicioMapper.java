package com.joaoamaral.GymWorkout.Mapper;

import com.joaoamaral.GymWorkout.Dto.Request.ExercicioRequestDto;
import com.joaoamaral.GymWorkout.Dto.Response.ExercicioResponseDto;
import com.joaoamaral.GymWorkout.Model.ExercicioModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ExercicioMapper{

    ExercicioMapper INSTANCE = Mappers.getMapper(ExercicioMapper.class);

    //@Mapping(target = "Id", ignore = true) // ID é gerado automaticamente
    @Mapping(source = "nomeDoExercicio", target = "nomeExercicio")
    @Mapping(source = "descricaoExercicio", target = "descricao")
    @Mapping(source = "categoria", target = "categoria")
    ExercicioModel requestToModel(ExercicioRequestDto dto);

    //@Mapping(source = "Id", target = "IdExercicio")
    @Mapping(source = "nomeExercicio", target = "nomeDoExercicio")
    @Mapping(source = "descricao", target = "descricaoExercicio")
    @Mapping(source = "categoria", target = "categoria")
    ExercicioResponseDto toDto(ExercicioModel model);

    //@Mapping(target = "Id", ignore = true) // Não atualizamos o ID durante a atualização
    @Mapping(source = "nomeDoExercicio", target = "nomeExercicio")
    @Mapping(source = "descricaoExercicio", target = "descricao")
    @Mapping(source = "categoria", target = "categoria")
    void updateModelFromDto(ExercicioRequestDto dto, @MappingTarget ExercicioModel model);

}
