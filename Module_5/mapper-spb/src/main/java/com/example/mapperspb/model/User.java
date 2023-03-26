package com.example.mapperspb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String password;
    private Integer age;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;


    @Override
    public String toString() {
        StringBuilder rolesStr = new StringBuilder("");
        for (Role role: roles){
            rolesStr.append(role.toString());
        }
        return "User{" +
               "fullName='" + fullName + '\'' +
               ", password='" + password + '\'' +
               ", age=" + age + '\'' +
                ",roles= " + rolesStr +
               '}';
    }
}
