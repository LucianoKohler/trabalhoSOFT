package com.brutebowling.dados;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Maquina {
    private String nome;
    private boolean multijogador;
    private Date dataUltimaManutencao;
    private int custoJogada;
    private List<Date> historicoUsos;

    public Maquina(String nome, boolean multijogador, int custoJogada) {
        this.nome = nome;
        this.multijogador = multijogador;
        this.custoJogada = custoJogada;
        this.dataUltimaManutencao = new Date();
        this.historicoUsos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isMultijogador() {
        return multijogador;
    }
    public void setMultijogador(boolean multijogador) {
        this.multijogador = multijogador;
    }
    public Date getDataUltimaManutencao() {
        return dataUltimaManutencao;
    }
    public void setDataUltimaManutencao(Date dataUltimaManutencao) {
        this.dataUltimaManutencao = dataUltimaManutencao;
    }
    public int getCustoJogada() {
        return custoJogada;
    }
    public void setCustoJogada(int custoJogada) {
        this.custoJogada = custoJogada;
    }
    public List<Date> getHistoricoUsos() {
        return historicoUsos;
    }
    public void registrarUso() {
        historicoUsos.add(new Date());
    }

    public Relatorio gerarRelatorioManual(Date inicio, Date fim) {
        YearMonth ym = YearMonth.from(fim.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        int usosPeriodo = (int) historicoUsos.stream().filter(d -> !d.before(inicio) && !d.after(fim)).count();
        return new Relatorio(ym, this, usosPeriodo);
    }

    public Relatorio gerarRelatorioAutomatico() {
        YearMonth ym = YearMonth.now();
        Date inicioMes = Date.from(ym.atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fimMes = Date.from(ym.atEndOfMonth().atStartOfDay(ZoneId.systemDefault()).toInstant());
        int usosMes = (int) historicoUsos.stream().filter(d -> !d.before(inicioMes) && !d.after(fimMes)).count();
        return new Relatorio(ym, this, usosMes);
    }
}