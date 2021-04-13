package com.altec.api.service;

import java.util.List;
import com.altec.api.persistence.entity.Cliente;

public interface ClientService {
    public List<Cliente> getAll();
    public Cliente save(Cliente c);
    public Cliente find(int idCliente);
    public void delete(int idCliente);
}
