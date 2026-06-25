package com.brutebowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.brutebowling.dados.Cliente;
import com.brutebowling.dados.Maquina;

public class ClienteTeste {

    private Cliente cliente;

    @BeforeEach
    public void setup(){
        cliente = new Cliente("123456789", "Marcos", "15670", new Date());
        cliente.setCredito(15);
    }

    @Test
    public void testRecarregaCreditoPositivo(){
        int qt = 5;
        cliente.recarregaCredito(qt);
        assertEquals(20, cliente.getCredito(), "Recarga nao foi completada.");
    }

    @Test
    public void testRecarregaCreditoNegativo(){
        int qt = -5;
        cliente.recarregaCredito(qt);
        assertEquals(15, cliente.getCredito(), "Recarga negativa deve ser ignorada.");
    }

    @Test
    public void testUsaCreditoValido(){
        Maquina mq = new Maquina("Space Invaders", false, 10);
        assumeTrue(cliente.usaCredito(mq), "Erro no uso da maquina pelo cliente");
        assertEquals(5, cliente.getCredito(), "Valor nao foi retirado da conta do cliente.");
    }
    @Test
    public void testUsaCreditoInvalido(){
        Maquina mq = new Maquina("Space Invaders", false, 25);
        assertFalse(cliente.usaCredito(mq), "Cliente nao deveria conseguir usar a maquina");
        assertEquals(15, cliente.getCredito(), "Conta do cliente deve permancer inalterada.");
    }
}
