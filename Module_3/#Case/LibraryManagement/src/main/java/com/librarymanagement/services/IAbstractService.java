package com.librarymanagement.services;

import java.util.Map;

public interface IAbstractService<Model, ID> {
    Map<ID,Model> getAll();

    Map<ID, Model> getAllExists();
    Model getById(ID id);

    boolean existsById(ID id);

    void add(Model newEntity);

    void update(Model newEntity);

    void deleteById(Long id);
}
