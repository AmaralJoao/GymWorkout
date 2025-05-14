package com.joaoamaral.GymWorkout.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "exercicio")
public class ExercicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdExercicio")
    private Long Id;

    @Column(name = "nmExercicio")
    private String nomeExercicio;

    @Column(name = "dsExercicio")
    private String descricao;

    @Column(name = "cdCategoria")
    private String categoria;

    public ExercicioModel() {
    }

    public ExercicioModel(String nomeExercicio, String descricao, String categoria) {
        this.nomeExercicio = nomeExercicio;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
