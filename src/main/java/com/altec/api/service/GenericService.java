package com.altec.api.service;

import java.util.List;

public interface GenericService<T> {
    public List<T> getAll();
    public T find(int idT);
    public T save(T c);
    public void delete(int idT);
}
