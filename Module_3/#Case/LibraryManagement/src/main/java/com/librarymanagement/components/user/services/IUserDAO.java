package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.User;
import com.librarymanagement.services.IAbstractService;

import java.sql.SQLException;
import java.util.Map;

public interface IUserDAO extends IAbstractService<User,Long> {

    boolean add(User newUser) throws SQLException;

    boolean update(User newUser) throws SQLException;
    Map<Long, User> getPaging(String pageDetails, String condition);
    void getUserRole(int id);

    int getNoOfRecords();
}
