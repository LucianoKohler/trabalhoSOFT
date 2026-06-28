package com.brutebowling.dados;

public class Produto {
    private String nome;
    private float preco;
    private boolean paraAdultos;
    private int estoque;
    private int estoqueMinimo;
    private boolean estoqueBaixo;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public boolean isParaAdultos() {
        return paraAdultos;
    }
    public void setParaAdultos(boolean paraAdultos) {
        this.paraAdultos = paraAdultos;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
    public boolean isEstoqueBaixo() {
        return estoqueBaixo;
    }
    public void setEstoqueBaixo(boolean estoqueBaixo) {
        this.estoqueBaixo = estoqueBaixo;
    }
    public Produto(String nome, float preco, boolean paraAdultos, int estoque, int estoqueMinino) {
        this.nome = nome;
        this.preco = preco;
        this.paraAdultos = paraAdultos;
        this.estoque = estoque;
        this.estoqueMinimo = estoqueMinino;
        this.estoqueBaixo = false;
    }

    public void checarBaixoEstoque(){
        if(estoque <= estoqueMinimo) estoqueBaixo = true;
        else estoqueBaixo = false;
    }    

    public boolean remocaoDeProduto(){
        if(estoque == 0){
            return false;
        }
        estoque--;
        checarBaixoEstoque();
        return true;
    }

    public void reposicaoDeProduto(int qtd){
        estoque += qtd;
        checarBaixoEstoque();
    }
}
