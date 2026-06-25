package com.brutebowling.dados;

import java.util.Date;

public class Reserva {
    private Cliente donoReserva;
    private Pista pista;
    private Funcionario reservador;
    private Date dataReserva;
    private float tempoReserva;
    
    public Cliente getDonoReserva() {
        return donoReserva;
    }
    public void setDonoReserva(Cliente donoReserva) {
        this.donoReserva = donoReserva;
    }
    public Pista getPista() {
        return pista;
    }
    public Funcionario getReservador() {
        return reservador;
    }
    public void setReservador(Funcionario reservador) {
        this.reservador = reservador;
    }
    public Date getDataReserva() {
        return dataReserva;
    }
    public float getTempoReserva() {
        return tempoReserva;
    }
    public void setTempoReserva(float tempoReserva) {
        this.tempoReserva = tempoReserva;
    }

    public Reserva(Cliente donoReserva, Pista pista, Funcionario reservador, Date dataReserva, float tempoReserva) {
        this.donoReserva = donoReserva;
        this.pista = pista;
        this.reservador = reservador;
        this.dataReserva = dataReserva;
        this.tempoReserva = tempoReserva;
    }

    public void alterarDataReserva(Date d){
        dataReserva = d;
    }

    public void alterarPista(Pista p){
        pista = p;
    }

    public void renovar(float tempo){
        if(tempo < 0.0f){
            System.out.println("ERRO: Tempo nao pode ser negativo.");
            return;
        }
        tempoReserva += tempo;
    }
}
