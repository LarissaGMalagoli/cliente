package br.com.meli.cliente.dto;


import br.com.meli.cliente.dao.ClienteRepository;
import br.com.meli.cliente.entity.Cliente;
import br.com.meli.cliente.entity.Pedido;

import java.util.List;

public class ClienteDTO {

    private String nome;
    private List<Pedido> pedidos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
/*
    public Cliente convert(ClienteRepository clienteRepository){
        return new Cliente(clienteRepository.getList()+1, totalPreco(), produtos);
    }
*/
}

