package com.brutebowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.brutebowling.dados.Cliente;
import com.brutebowling.dados.Comanda;
import com.brutebowling.dados.Produto;

public class ComandaTeste {

    private Comanda comanda;
    private Produto produto;

    @BeforeEach
    public void setup() {
        Cliente c = new Cliente("123456789", "Marcos", "15670", new Date());
        comanda = new Comanda(c);
        produto = new Produto("Batata Frita", 15.0f, false, 10, 2);
    }

    @Test
    public void testInserirProduto(){
        comanda.inserirProduto(produto, 5);

        for(Produto p : comanda.getProdutos()){
            assertEquals(produto, p, "Produto errado foi adicionado a comanda.");
        }

        assertEquals(5, comanda.getProdutos().size(), "Quantidade de produtos esta errada.");

    }

    @Test
    public void testRemoverProduto(){
        comanda.inserirProduto(produto, 5);
        comanda.removerProduto(produto, 3);

        assertEquals(2, comanda.getProdutos().size(), "Quantidade de produtos esta errada.");

    }

    @Test
    public void testPedirComEstoque(){
        comanda.inserirProduto(produto, 3);
        
        comanda.pedir();

        assertEquals(0, comanda.getProdutos().size(), "Produtos deveria estar vazio.");
        assertEquals(produto.getPreco() * 3, comanda.getTotal(), 0.0001f, "Total esta errado.");
    }

    @Test
    public void testPedirSemEstoque(){
        produto.setEstoque(1);
        comanda.inserirProduto(produto, 3);
        
        comanda.pedir();
        
        assertEquals(0, comanda.getProdutos().size(), "Produtos deveria estar vazio.");
        assertEquals(produto.getPreco(), comanda.getTotal(), 0.0001f, "Total esta incorreto.");
    }

    @Test
    public void testPedirVazio(){
        comanda.pedir();

        assertEquals(0, comanda.getProdutos().size(), "Produtos deveria estar vazio.");
        assertEquals(0, comanda.getTotal(), 0.0001f, "Total deveria ser nulo.");
    }

    @Test
    public void testCheckout(){
        assertFalse(comanda.isPago(), "Comanda ainda nao foi paga.");
        comanda.checkout();
        assertTrue(comanda.isPago(), "Comanda ja foi paga.");
    }
}
