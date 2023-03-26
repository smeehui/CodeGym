package com.example.mapperspb.model.dto;

import com.example.mapperspb.model.dto.RoleDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String fullName;
    private String password;

    private List<RoleDTO> roles;
    private String age;

    @Override
    public String toString() {
        StringBuilder roles = new StringBuilder("");
        for (RoleDTO role: this.getRoles()){
            roles.append(role.toString());
        }
        return "UserDTO{" +
               "fullName='" + fullName + '\'' +
               ", password='" + password + '\'' +
               ", roles=" + roles +
               ", age='" + age + '\'' +
               '}';
    }
}
