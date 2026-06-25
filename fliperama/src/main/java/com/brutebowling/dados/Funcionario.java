package com.brutebowling.dados;

import java.util.Date;

public class Funcionario {
    private String nome;
    private float salario;
    private Date dataContratacao;
    private String cargo;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public Date getDataContratacao() {
        return dataContratacao;
    }
    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Chamado abrirChamado(Maquina m, String desc){
        if(m == null){
            return null;
        }
        Chamado novoChamado = new Chamado(this, m, desc);
        m.requisitarManutencao();

        return novoChamado;
    }

    public boolean atenderChamado(Chamado c){
        if(c.isConcluido()){
            return false;
        }
        c.setResponsavel(this);
        c.completarChamado();
        
        return true;
    }

    public Funcionario(String nome, float salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
        this.dataContratacao = new Date();
    }
}