package com.brutebowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.brutebowling.dados.Maquina;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MaquinaTeste {
    private Maquina maquina;
 
    @BeforeEach
    public void setUp() {
        maquina = new Maquina("Pac-Man", false, 2);
    }

    // Isso é pra ajudar com as datas pros testes e tals
    // Pega o dia de hoje menos N meses ou Menos N dias
    private Date menosNMeses(int meses) {
        return Date.from(LocalDate.now().minusMonths(meses).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
 
    private Date menosNDias(int dias) {
        return Date.from(LocalDate.now().minusDays(dias).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Test
    public void testeRequisitarManutencaoSetaFlagComoTrue() {
        assertFalse(maquina.getPrecisaDeManutencao());
 
        maquina.requisitarManutencao();
 
        assertTrue(maquina.getPrecisaDeManutencao());
    }

    @Test
    void testeManutencaoRealizadaResetaFlagEAtualizaData() {
        maquina.setPrecisaDeManutencao(true);
        maquina.setDataUltimaManutencao(menosNMeses(4));
 
        Date antes = new Date();
        maquina.manutencaoRealizada();
        Date depois = new Date();
 
        assertFalse(maquina.getPrecisaDeManutencao());
        assertFalse(maquina.getDataUltimaManutencao().before(antes));
        assertFalse(maquina.getDataUltimaManutencao().after(depois));
    }

}
