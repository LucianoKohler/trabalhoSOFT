package com.brutebowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.brutebowling.dados.Produto;

public class ProdutoTeste {

    private Produto produto;

    @BeforeEach
    public void setup() {
        produto = new Produto("Pizza", 45.0f, false, 15, 4);
    }

    @Test
    public void testChecarBaixoEstoqueTrue(){
        produto.setEstoque(3);
        assertFalse(produto.isEstoqueBaixo(), "Estoque ainda nao foi checado.");
        produto.checarBaixoEstoque();
        assertTrue(produto.isEstoqueBaixo(), "Estoque deveria estar baixo.");
    }

    @Test
    public void testChecarBaixoEstoqueFalse(){
        produto.setEstoque(20);
        assertFalse(produto.isEstoqueBaixo(), "Estoque ainda nao foi checado.");
        produto.checarBaixoEstoque();
        assertFalse(produto.isEstoqueBaixo(), "Estoque nao deveria estar baixo.");
    }

    @Test
    public void testRemocaoDeProdutoTrue(){
        int qt = produto.getEstoque();
        assertTrue(produto.remocaoDeProduto(), "Produto deveria ter sido removido com sucesso.");
        assertEquals(qt-1, produto.getEstoque(), "Produto nao foi removido.");
    }

    @Test
    public void testRemocaoDeProdutoFalse(){
        produto.setEstoque(0);
        int qt = produto.getEstoque();
        assertFalse(produto.remocaoDeProduto(), "Nao ha produtos para remover.");
        assertEquals(qt, produto.getEstoque(), "Nao ha produtos para remover.");
    }

    @Test
    public void testReposicaoDeProduto(){
        int qt = produto.getEstoque();
        produto.reposicaoDeProduto(10);
        assertEquals(qt+10, produto.getEstoque(), "Quantidade adicionada esta errada.");
    }
}
