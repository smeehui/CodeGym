package com.librarymanagement.services;

import com.librarymanagement.components.user.models.User;

import java.sql.SQLException;
import java.util.Map;

public interface IAbstractService<Model, ID> {
    Map<ID, Model> getAll();

    Map<ID, Model> getAllExists();
    Model getById(long id);

    boolean existsById(ID id);

    boolean add(Model newEntity) throws SQLException;

    boolean update(Model newEntity) throws SQLException;

    boolean deleteById(Long id);

    boolean isDeleted(Long id);
    Map<ID, Model> search(String query, String s);

    int getNoOfRecords();

    Map<ID, Model> getPaging(String pageDetails, String condition);
}
