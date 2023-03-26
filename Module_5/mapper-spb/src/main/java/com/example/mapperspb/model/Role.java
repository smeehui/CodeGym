package com.example.mapperspb.model;

import com.example.mapperspb.mapper.ERole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private ERole role;

    public Role() {
    }

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
               "role=" + role +
               '}';
    }
}
