package br.com.meli.cliente.dao;

import br.com.meli.cliente.entity.Cliente;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private static final File FILE = new File("cliente.json");

    ObjectMapper mapper;

    public ClienteRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }


    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {};
            clientes = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public Cliente findById(int id){
        return findAll().get(id);
    }

    public int getList(){
        return findAll().size();
    }

    public void add(Cliente cliente) {
        try {
            List<Cliente> clientes = findAll();
            clientes.add(cliente);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, clientes);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
