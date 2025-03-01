package com.example.rotinas_diarias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String status;
    private String prioridade;

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public String getStatus() {
        return status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
        
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}
