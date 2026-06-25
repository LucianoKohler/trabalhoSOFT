package com.brutebowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.brutebowling.dados.Chamado;
import com.brutebowling.dados.Maquina;

public class ChamadoTeste {
    private Maquina maquina;
    private Chamado chamado;
 
    @BeforeEach
    public void setUp() {
        maquina = new Maquina("Pac-Man", false, 2);
        maquina.requisitarManutencao();
 
        chamado = new Chamado();
        chamado.setMaquina(maquina);
    }

    @Test
    public void testeCompletarChamadoMarcaComoConcluidoERegistraData() {
        assertFalse(chamado.isConcluido());
        assertNull(chamado.getDataConclusao());
 
        Date antes = new Date();
        chamado.completarChamado();
        Date depois = new Date();
 
        assertTrue(chamado.isConcluido());
        assertFalse(chamado.getDataConclusao().before(antes));
        assertFalse(chamado.getDataConclusao().after(depois));
    }
 
    @Test
    public void testeCompletarChamadoRealizaManutencaoNaMaquina() {
        assertTrue(maquina.getPrecisaDeManutencao());
        
        Date antes = new Date();
        chamado.completarChamado();
        Date depois = new Date();

        assertFalse(maquina.getPrecisaDeManutencao());
        assertFalse(maquina.getDataUltimaManutencao().before(antes));
        assertFalse(maquina.getDataUltimaManutencao().after(depois));
    }

}
