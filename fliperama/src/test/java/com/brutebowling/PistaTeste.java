package com.brutebowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.brutebowling.dados.Pista;

public class PistaTeste {

    private Pista pista;

    @BeforeEach
    public void setup() {
        pista = new Pista(false, "livre", 100.0f, new Date());
    }

    @Test
    public void testeAlteraEstado(){
        pista.alteraEstado("ocupado");

        assertEquals("ocupado", pista.getEstado(), "Estado da pista nao foi alterado.");
    }

    @Test
    public void testeAlteraNivel(){
        assertFalse(pista.isVIP());
        pista.alteraNivel(true);

        assertTrue(pista.isVIP(), "Pista deveria ser VIP");
    }
}
