package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.User;
import com.librarymanagement.services.IAbstractService;

public interface IUserDAO extends IAbstractService<User,Integer> {

    boolean add(User newUser);

    void update(User newUser);
    void getUserRole(int id);
}
