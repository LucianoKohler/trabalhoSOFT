package com.brutebowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.brutebowling.dados.Chamado;
import com.brutebowling.dados.Funcionario;
import com.brutebowling.dados.Maquina;

public class FuncionarioTeste {

    private Funcionario funcionario;
    private Maquina maquina;

    @BeforeEach
    public void setup() {
        funcionario = new Funcionario("Luciano", 2000f, "Caixista");
        maquina = new Maquina("Donkey Kong", false, 10);
    }

    @Test
    public void testeAbrirChamadoNull(){
        assertEquals(null, funcionario.abrirChamado(null, "defeito no joystick"), "Chamado deveria ser nulo.");
    }

    @Test
    public void testeAbrirChamadoValido(){
        Chamado c = funcionario.abrirChamado(maquina, "defeito no joystick");
        
        assertEquals(funcionario,c.getEmissor(), "Funcionario do chamado nao esta correto.");
        assertEquals(maquina, c.getMaquina(), "Maquina do chamado esta errada.");
        assertEquals("defeito no joystick", c.getDescricao(), "Descricao do chamado esta errada.");
    }

    @Test
    public void testeAtenderChamadoConcluido(){
        Chamado c = funcionario.abrirChamado(maquina, "defeito no joystick");

        c.setConcluido(true);
        assertFalse(funcionario.atenderChamado(c), "Chamado ja foi concluido.");

    }

    @Test
    public void testeAtenderChamadoValido(){
        Chamado c = funcionario.abrirChamado(maquina, "defeito no joystick");

        assertTrue(funcionario.atenderChamado(c), "Chamado ainda nao foi concluido.");
        assertEquals(funcionario, c.getResponsavel(), "Responsavel nao foi designado.");
        assertTrue(c.isConcluido(), "Chamado ja foi concluido.");
    }

}
