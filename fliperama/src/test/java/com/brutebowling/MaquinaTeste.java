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
        maquina = new Maquina("BowlingPro", true, 5);
    }

    @Test
    public void testRequisitarManutencaoSetaFlagComoTrue() {
        assertFalse(maquina.getPrecisaDeManutencao());
 
        maquina.requisitarManutencao();
 
        assertTrue(maquina.getPrecisaDeManutencao());
    }

}
