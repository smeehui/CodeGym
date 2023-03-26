package com.example.mapperspb.model.dto;

import com.example.mapperspb.mapper.ERole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDTO {
    @Enumerated(EnumType.STRING)
    private ERole role;

    @Override
    public String toString() {
        return "RoleDTO{" +
               "role='" + role + '\'' +
               '}';
    }
}
