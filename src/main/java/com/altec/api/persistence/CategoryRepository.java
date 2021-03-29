package com.altec.api.persistence;

import java.util.List;

import com.altec.api.persistence.entity.Categoria;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Categoria, Integer>{
    List<Categoria> findAllByOrderByIdCategoriaDesc(); 
}
