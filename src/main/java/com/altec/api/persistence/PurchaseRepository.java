package com.altec.api.persistence;

import java.util.List;

import com.altec.api.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Compra, Integer> {
    List<Compra> findAll();
}
