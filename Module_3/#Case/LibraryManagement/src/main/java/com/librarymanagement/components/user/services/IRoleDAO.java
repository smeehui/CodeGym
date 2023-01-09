package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.Role;
import com.librarymanagement.services.IAbstractService;

import java.util.List;
import java.util.Map;

public interface IRoleDAO {
    Role getByID(int id);
    Map<Integer,Role> getAll();

    boolean add(Role newRole);
}
