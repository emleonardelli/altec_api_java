package com.altec.api.service.impl;

import java.util.List;

import com.altec.api.persistence.CategoryRepository;
import com.altec.api.persistence.entity.Categoria;
import com.altec.api.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Categoria> getAll() {
        return (List<Categoria>) categoryRepository.findAllByOrderByIdCategoriaDesc();
    }

    public Categoria save(Categoria c) {
        return categoryRepository.save(c);
    }

    public Categoria find(int idCategoria) {
        return categoryRepository.findById(idCategoria)
            .map(p -> p.get())
            .orElse(null);
    }

    public void delete(int idCategoria) {
        categoryRepository.deleteById(idCategoria);
    }

    public List<Categoria> getActives() {
        return categoryRepository.findAllByEstado(true);
    }
}
