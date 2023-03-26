package com.example.mapperspb.config;

import com.example.mapperspb.mapper.RoleMapper;
import com.example.mapperspb.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyBeans {
    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

    @Bean
    public RoleMapper roleMapper() {
        return new RoleMapper();
    }
}
