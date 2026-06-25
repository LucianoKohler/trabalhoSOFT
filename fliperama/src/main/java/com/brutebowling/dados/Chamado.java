package com.brutebowling.dados;

import java.time.LocalDate;

public class Chamado {
    private Funcionario emissor;
    private Maquina maquina;
    private Funcionario responsavel;
    private String descricao;
    private boolean concluido;
    private LocalDate dataConclusao;

    public Funcionario getEmissor() {
        return emissor;
    }

    public void setEmissor(Funcionario emissor) {
        this.emissor = emissor;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void completarChamado() {
        this.concluido = true;
        this.dataConclusao = LocalDate.now();
    }

    public Chamado(Funcionario emissor, Maquina maquina, Funcionario responsavel, String descricao) {
        this.emissor = emissor;
        this.maquina = maquina;
        this.responsavel = responsavel;
        this.descricao = descricao;
        this.concluido = false;
        this.dataConclusao = null;
    }

    public Chamado() {

    }
}