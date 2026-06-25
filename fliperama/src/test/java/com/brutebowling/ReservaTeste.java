package com.brutebowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.brutebowling.dados.Cliente;
import com.brutebowling.dados.Funcionario;
import com.brutebowling.dados.Pista;
import com.brutebowling.dados.Reserva;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ReservaTeste {
    private Reserva reserva;

    @BeforeEach
    public void setup() {
        Cliente c = new Cliente("123", "Carlos", "123-123", new Date());
        Pista p = new Pista(false, "nova", 100, new Date());
        Funcionario f = new Funcionario("Maria", 2000f, "Caixista");
        reserva = new Reserva(c, p, f, new Date(), 1.0f);
    }

    @Test
    public void testRenovarPositivo() {
        reserva.renovar(1.0f);
        assertEquals(2.0f, reserva.getTempoReserva(), "Tempo de reserva esta errado.");
    }

    @Test
    public void testRenovarNegativo() {
        reserva.renovar(-1.0f);
        assertEquals(1.0f, reserva.getTempoReserva(), "Tempo de reserva nao deveria ter sido alterado.");
    }

    @Test
    public void testRenovarNulo() {
        reserva.renovar(0.0f);
        assertEquals(1.0f, reserva.getTempoReserva(), "Tempo de reserva nao deveria ter sido alterado.");
    }
}