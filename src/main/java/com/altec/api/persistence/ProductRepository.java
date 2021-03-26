package com.altec.api.persistence;

import java.util.List;

import com.altec.api.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findAllByOrderByIdProductoDesc(); 
}
