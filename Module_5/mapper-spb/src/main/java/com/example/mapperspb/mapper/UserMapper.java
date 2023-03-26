package com.example.mapperspb.mapper;


import com.example.mapperspb.model.User;
import com.example.mapperspb.model.dto.UserDTO;

import java.util.stream.Collectors;

public class UserMapper {
    private static UserMapper INSTANCE;

    public static void setINSTANCE(UserMapper INSTANCE) {
        UserMapper.INSTANCE = INSTANCE;
    }

    public static UserMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserMapper();
        }
        return INSTANCE;
    }



    public UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setFullName(user.getFullName());
        dto.setAge(user.getAge().toString());
        dto.setPassword(user.getPassword());
        dto.setRoles(user.getRoles().stream()
                .map(role -> RoleMapper.getInstance().toDto(role))
                .collect(Collectors.toList()));
        return dto;
    }

    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setFullName(dto.getFullName());
        user.setPassword(dto.getPassword());
        user.setAge(Integer.parseInt(dto.getAge()));
        user.setRoles(dto.getRole().stream().map(roleDTO -> RoleMapper.getInstance().toEntity(roleDTO)).collect(Collectors.toList()));
        return user;
    }


}
