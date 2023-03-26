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


    public UserDTO(String fullName, String password, List<RoleDTO> roles, String age) {
        this.fullName = fullName;
        this.password = password;
        this.roles = roles;
        this.age = age;
    }

    public UserDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDTO> getRole() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder roles = new StringBuilder("");
        for (RoleDTO role: this.getRole()){
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
