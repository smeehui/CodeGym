package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.User;
import com.librarymanagement.services.IAbstractService;

import java.sql.SQLException;

public interface IUserDAO extends IAbstractService<User,Long> {

    boolean add(User newUser) throws SQLException;

    boolean update(User newUser) throws SQLException;
    void getUserRole(int id);
}
