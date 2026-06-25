package com.brutebowling.dados;

import java.time.YearMonth;

public class Relatorio {
    private YearMonth mesAno;
    private Maquina maquina;
    private int qtdUsos;
    private int lucroGerado;

    public YearMonth getMesAno() {
        return mesAno;
    }
    public void setMesAno(YearMonth mesAno) {
        this.mesAno = mesAno;
    }
    public Maquina getMaquina() {
        return maquina;
    }
    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
    public int getQtdUsos() {
        return qtdUsos;
    }
    public void setQtdUsos(int qtdUsos) {
        this.qtdUsos = qtdUsos;
    }
    public void calcularLucro(){
        lucroGerado = qtdUsos * maquina.getCustoJogada();
    }
    public int getLucroGerado() {
        return lucroGerado;
    }

    public Relatorio(YearMonth mesAno, Maquina maquina, int qtdUsos){
        this.mesAno = mesAno;
        this.maquina = maquina;
        this.qtdUsos = qtdUsos;
        this.lucroGerado = qtdUsos * maquina.getCustoJogada();
    }

}