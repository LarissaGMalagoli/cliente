package br.com.meli.cliente.service;

import java.util.List;

import br.com.meli.cliente.dao.ClienteRepository;
import br.com.meli.cliente.dto.ClienteDTO;
import br.com.meli.cliente.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class ClienteService {

    ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(int id){
        return clienteRepository.findById(id);
    }


    public ResponseEntity<Cliente> add(Cliente cliente, UriComponentsBuilder uriBuilder) {
        //Cliente cliente = dto.convert();
        clienteRepository.add(cliente);

        return ResponseEntity.ok().body(cliente);
    }

}
