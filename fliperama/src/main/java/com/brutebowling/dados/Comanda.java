package com.brutebowling.dados;

import java.time.LocalDate;
import java.util.ArrayList;

public class Comanda {
    private ArrayList<Produto> produtos;
    private Cliente donoComanda;
    private boolean pago;
    private LocalDate dataCriacaoComanda;
    private float total;

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    public Cliente getDonoComanda() {
        return donoComanda;
    }
    public void setDonoComanda(Cliente donoComanda) {
        this.donoComanda = donoComanda;
    }
    public boolean isPago() {
        return pago;
    }
    public void setPago(boolean pago) {
        this.pago = pago;
    }
    public LocalDate getDataCriacaoComanda() {
        return dataCriacaoComanda;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }

    public Comanda(Cliente donoComanda) {
        this.produtos = new ArrayList<>();
        this.donoComanda = donoComanda;
        this.pago = false;
        this.dataCriacaoComanda = LocalDate.now();
        this.total = 0;
    }

    public void inserirProduto(Produto p, int qtd){
        for(int i = 0; i < qtd; i++) produtos.add(p);
    }

    public void removerProduto(Produto p, int qtd){
        for(int i = 0; i < qtd; i++) produtos.remove(p);
    }

    public void pedir(){
        for(Produto p: produtos){
            p.remocaoDeProduto();
            total += p.getPreco();
        }

        produtos.clear();
    }

    public void checkout(){
        pago = true;
    }
    
}
