package br.com.meli.cliente.dto;

import br.com.meli.cliente.dao.ClienteRepository;
import br.com.meli.cliente.entity.Pedido;
import br.com.meli.cliente.entity.Produto;

import java.util.List;

public class PedidoDTO {

    private List<Produto> produtos;


    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    private double totalPreco(){
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    public Pedido convert(ClienteRepository clienteRepository){
        return new Pedido(clienteRepository.getList()+1, totalPreco(), produtos);
    }

}
