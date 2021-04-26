package com.altec.api.service;

import java.util.List;
import com.altec.api.persistence.entity.Categoria;

public interface CategoryService extends GenericService<Categoria> {
    public List<Categoria> getActives();
}
