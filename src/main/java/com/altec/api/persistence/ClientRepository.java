package com.altec.api.persistence;

import com.altec.api.persistence.entity.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Cliente, Integer>{
    
}
