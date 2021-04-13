package com.altec.api.service;

import java.util.List;
import com.altec.api.persistence.entity.Categoria;

public interface CategoryService {
    public List<Categoria> getAll();
    public Categoria save(Categoria c);
    public Categoria find(int idCategoria);
    public void delete(int idCategoria);
    public List<Categoria> getActives();
}
