package br.com.meli.cliente;

import java.net.URI;
import java.util.List;

import br.com.meli.cliente.entity.Cliente;
import br.com.meli.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/cliente")
public class ClienteController {


    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> clientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente cliente(@PathVariable int id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> add(@RequestBody Cliente cliente, UriComponentsBuilder uriBuilder){
        return clienteService.add(cliente, uriBuilder);
    }

}
