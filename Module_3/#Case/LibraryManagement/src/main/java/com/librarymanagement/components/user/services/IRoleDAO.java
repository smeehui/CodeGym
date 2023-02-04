package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.Role;

import java.util.Map;

public interface IRoleDAO {
    Role getByID(int id);
    Map<Integer,Role> getAll();

    boolean add(Role newRole);
}
