package com.brutebowling.dados;

import java.util.Date;

public class Cliente {
    private String CPF;
    private String nome;
    private String telefone;
    private Date dataNasc;
    private int credito;
    
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cPF) {
        CPF = cPF;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Date getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    public int getCredito() {
        return credito;
    }
    public void setCredito(int credito) {
        this.credito = credito;
    }
    public Cliente(String CPF, String nome, String telefone, Date dataNasc) {
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.credito = 0;
    }

    public void recarregaCredito(int qtd){
        credito += qtd;
    }

    public boolean usaCredito(Maquina maquina){
        if(credito < maquina.getCustoJogada()) return false;

        credito -= maquina.getCustoJogada();
        return true;
    }
}
