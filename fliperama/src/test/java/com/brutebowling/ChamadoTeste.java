package com.brutebowling;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
 
        assertTrue(chamado.isConcluido(), "Chamado não foi marcado como concluido");
        assertFalse(chamado.getDataConclusao().before(antes),"Data registrada incorretamente");
        assertFalse(chamado.getDataConclusao().after(depois), "Data registrada incorretamente");
    }
 
    @Test
    public void testeCompletarChamadoRealizaManutencaoNaMaquina() {
        assertTrue(maquina.getPrecisaDeManutencao());
        
        Date antes = new Date();
        chamado.completarChamado();
        Date depois = new Date();

        assertFalse(maquina.getPrecisaDeManutencao(),"Máquina continua marcada como precisando de manutenção");
        assertFalse(maquina.getDataUltimaManutencao().before(antes), "Data registrada incorretamente");
        assertFalse(maquina.getDataUltimaManutencao().after(depois), "Data registrada incorretamente");
    }

}
