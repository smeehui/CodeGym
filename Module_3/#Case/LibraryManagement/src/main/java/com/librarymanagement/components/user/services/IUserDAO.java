package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.User;
import com.librarymanagement.services.IAbstractService;

public interface IUserDAO extends IAbstractService<User,Integer> {

    void add(User newUser);

    void getUserRole(int id);
    void update(User newUser);

    boolean existById(long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);
}
