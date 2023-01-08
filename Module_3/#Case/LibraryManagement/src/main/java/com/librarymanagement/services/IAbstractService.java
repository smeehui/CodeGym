package com.librarymanagement.services;

import com.librarymanagement.components.user.models.User;

import java.util.Map;

public interface IAbstractService<Model, ID> {
    Map<ID, Model> getAll();

    Map<ID, Model> getAllExists();
    Model getById(long id);

    boolean existsById(ID id);

    boolean add(Model newEntity);

    void update(Model newEntity);

    boolean deleteById(Long id);

    boolean isDeleted(Long id);
}
