package com.librarymanagement.components.user.services;

public interface IUserValidate {

    boolean existById(long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);
}
