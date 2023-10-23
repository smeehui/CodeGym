package com.example.mapperspb.repository;

import com.example.mapperspb.mapper.ERole;
import com.example.mapperspb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(ERole role);
}
