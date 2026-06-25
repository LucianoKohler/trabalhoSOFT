package com.brutebowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.brutebowling.dados.Maquina;
import com.brutebowling.dados.Relatorio;

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
    public void testeRegistrarUsoAdicionaDataAoHistorico() {
        List<Date> historico = maquina.getHistoricoUsos();
 
        assertTrue(historico.isEmpty());
 
        maquina.registrarUso();
        assertEquals(1, historico.size());
 
        maquina.registrarUso();
        assertEquals(2, historico.size());
    }

    @Test
    public void testeRequisitarManutencaoSetaFlagComoTrue() {
        assertFalse(maquina.getPrecisaDeManutencao());
 
        maquina.requisitarManutencao();
 
        assertTrue(maquina.getPrecisaDeManutencao());
    }

    @Test
    public void testeManutencaoRealizadaResetaFlagEAtualizaData() {
        maquina.setPrecisaDeManutencao(true);
        maquina.setDataUltimaManutencao(menosNMeses(4));
 
        Date antes = new Date();
        maquina.manutencaoRealizada();
        Date depois = new Date();
 
        assertFalse(maquina.getPrecisaDeManutencao());
        assertFalse(maquina.getDataUltimaManutencao().before(antes));
        assertFalse(maquina.getDataUltimaManutencao().after(depois));
    }

    @Test
    public void testeGerarRelatorioManualSemManutencaoPendente() {
        maquina.setDataUltimaManutencao(menosNMeses(1));

        maquina.registrarUso();
        maquina.registrarUso();

        Date inicio = menosNDias(7);
        Date fim = new Date();
 
        Relatorio relatorio = maquina.gerarRelatorioManual(inicio, fim);
 
        assertNotNull(relatorio);
        assertEquals(maquina, relatorio.getMaquina());
        assertEquals(2, relatorio.getQtdUsos());
        assertEquals(4, relatorio.getLucroGerado());
        assertFalse(maquina.getPrecisaDeManutencao()); 
    }

    @Test
    public void testeGerarRelatorioManualComManutencaoPendente() {
        maquina.setDataUltimaManutencao(menosNMeses(4));
        
        maquina.registrarUso();
        maquina.registrarUso();
        
        Date inicio = menosNDias(7);
        Date fim = new Date();
 
        Relatorio relatorio = maquina.gerarRelatorioManual(inicio, fim);
 
        assertNotNull(relatorio);
        assertEquals(maquina, relatorio.getMaquina());
        assertEquals(2, relatorio.getQtdUsos());
        assertEquals(4, relatorio.getLucroGerado());
        assertTrue(maquina.getPrecisaDeManutencao());
    }

    @Test
    public void testeGerarRelatorioManualContaApenasUsosDentroDoPeriodo() {
        maquina.setDataUltimaManutencao(menosNMeses(1));
 
        Date inicio = menosNDias(7);
        Date fim = menosNDias(1);
 
        maquina.getHistoricoUsos().add(menosNDias(10));
        maquina.getHistoricoUsos().add(new Date());
        maquina.getHistoricoUsos().add(menosNDias(5));
        maquina.getHistoricoUsos().add(menosNDias(1));
        maquina.getHistoricoUsos().add(menosNDias(3));
 
        Relatorio relatorio = maquina.gerarRelatorioManual(inicio, fim);
 
        assertNotNull(relatorio);
        assertEquals(maquina, relatorio.getMaquina());
        assertEquals(3, relatorio.getQtdUsos());
        assertEquals(6, relatorio.getLucroGerado());
        assertFalse(maquina.getPrecisaDeManutencao());
    }

    @Test
    public void testeGerarRelatorioAutomaticoSemManutencaoPendente() {
        maquina.setDataUltimaManutencao(menosNMeses(1));
 
        maquina.registrarUso(); 
        maquina.registrarUso(); 
 
        Relatorio relatorio = maquina.gerarRelatorioAutomatico();
 
        assertNotNull(relatorio);
        assertEquals(maquina, relatorio.getMaquina());
        assertEquals(2, relatorio.getQtdUsos());
        assertEquals(4, relatorio.getLucroGerado());
        assertFalse(maquina.getPrecisaDeManutencao()); 
    }

    @Test
    public void testeGerarRelatorioAutomaticoComManutencaoPendente() {
        maquina.setDataUltimaManutencao(menosNMeses(4));
 
        maquina.registrarUso(); 
        maquina.registrarUso(); 

        Relatorio relatorio = maquina.gerarRelatorioAutomatico();
 
        assertNotNull(relatorio);
        assertEquals(maquina, relatorio.getMaquina());
        assertEquals(2, relatorio.getQtdUsos());
        assertEquals(4, relatorio.getLucroGerado());
        assertTrue(maquina.getPrecisaDeManutencao()); 
    }

    @Test
    public void testeGerarRelatorioAutomaticoIgnoraUsosDeMesesAnteriores() {
        maquina.setDataUltimaManutencao(menosNMeses(1));
 
        maquina.getHistoricoUsos().add(menosNMeses(2));
        maquina.getHistoricoUsos().add(menosNMeses(3));
        maquina.registrarUso(); 
        maquina.registrarUso(); 
 
        Relatorio relatorio = maquina.gerarRelatorioAutomatico();
 
        assertNotNull(relatorio);
        assertEquals(maquina, relatorio.getMaquina());
        assertEquals(2, relatorio.getQtdUsos());
        assertEquals(4, relatorio.getLucroGerado());
        assertFalse(maquina.getPrecisaDeManutencao()); 
    }
}
