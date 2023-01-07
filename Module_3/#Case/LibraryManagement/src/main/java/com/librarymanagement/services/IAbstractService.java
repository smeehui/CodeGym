package com.librarymanagement.services;

import com.librarymanagement.components.user.models.User;

import java.util.Map;

public interface IAbstractService<Model, ID> {
    Map<Long, User> getAll();

    Map<Long, User> getAllExists();
    Model getById(long id);

    boolean existsById(ID id);

    boolean add(Model newEntity);

    void update(Model newEntity);

    void deleteById(Long id);
}
