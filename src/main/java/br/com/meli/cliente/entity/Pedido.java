package br.com.meli.cliente.entity;

import java.util.List;

public class Pedido {
    private long id;
    private double preco;
    private List<Produto> produtos;

    public Pedido(long id, double preco, List<Produto> produtos) {
        this.id = id;
        this.preco = preco;
        this.produtos = produtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setProduto(Produto p) {
        produtos.add(p);
    }


}
