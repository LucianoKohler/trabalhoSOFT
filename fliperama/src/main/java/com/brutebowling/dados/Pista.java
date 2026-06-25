package com.brutebowling.dados;

import java.util.Date;

public class Pista {
    private boolean VIP;
    private String estado;
    private float precoReserva;
    private Date dataUltimaManutencao;

    public boolean isVIP() {
        return VIP;
    }
    public String getEstado() {
        return estado;
    }
    public float getPrecoReserva() {
        return precoReserva;
    }
    public void setPrecoReserva(float precoReserva) {
        this.precoReserva = precoReserva;
    }
    public Date getDataUltimaManutencao() {
        return dataUltimaManutencao;
    }
    public void setDataUltimaManutencao(Date dataUltimaManutencao) {
        this.dataUltimaManutencao = dataUltimaManutencao;
    }
    public Pista(boolean vIP, String estado, float precoReserva, Date dataUltimaManutencao) {
        VIP = vIP;
        this.estado = estado;
        this.precoReserva = precoReserva;
        this.dataUltimaManutencao = dataUltimaManutencao;
    }

    public void alteraEstado(String estado){
        this.estado = estado;
    }

    public void alteraNivel(boolean nivel){
        VIP = nivel;
    }
    
}
