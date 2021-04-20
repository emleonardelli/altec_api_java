package com.altec.api.persistence;

import com.altec.api.persistence.entity.CompraProducto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseProductRepository extends CrudRepository<CompraProducto, Integer> {
}
