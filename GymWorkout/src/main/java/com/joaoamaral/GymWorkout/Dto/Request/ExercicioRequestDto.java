package com.joaoamaral.GymWorkout.Dto.Request;

public class ExercicioRequestDto {

    private Long IdExercicio;

    private String nomeDoExercicio;

    private String descricaoExercicio;

    private String categoria;

    public Long getIdExercicio() {
        return IdExercicio;
    }

    public void setIdExercicio(Long idExercicio) {
        IdExercicio = idExercicio;
    }

    public String getNomeDoExercicio() {
        return nomeDoExercicio;
    }

    public void setNomeDoExercicio(String nomeDoExercicio) {
        this.nomeDoExercicio = nomeDoExercicio;
    }

    public String getDescricaoExercicio() {
        return descricaoExercicio;
    }

    public void setDescricaoExercicio(String descricaoExercicio) {
        this.descricaoExercicio = descricaoExercicio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
