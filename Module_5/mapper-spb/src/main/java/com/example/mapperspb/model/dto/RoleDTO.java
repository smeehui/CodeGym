package com.example.mapperspb.model.dto;

import com.example.mapperspb.mapper.ERole;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDTO {
    private ERole role;

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public RoleDTO(ERole role) {
        this.role = role;
    }

    public RoleDTO() {
    }


    @Override
    public String toString() {
        return "RoleDTO{" +
               "role='" + role + '\'' +
               '}';
    }
}
