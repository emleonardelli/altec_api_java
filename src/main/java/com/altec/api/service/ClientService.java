package com.altec.api.service;

import java.util.List;

import com.altec.api.persistence.ClientRepository;
import com.altec.api.persistence.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Cliente> getAll() {
        return  (List<Cliente>) clientRepository.findAll();
    }

    public Cliente save(Cliente c) {
        return clientRepository.save(c);
    }

    public Cliente find(int idCliente) {
        return clientRepository.findById(idCliente)
            .map(p -> p.get())
            .orElse(null);
    }

    public void delete(int idCliente) {
        clientRepository.deleteById(idCliente);
    }
}
