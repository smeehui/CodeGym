package com.example.mapperspb.service;

import com.example.mapperspb.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements GeneralService<UserDTO> {

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return null;
    }

    @Override
    public void delete(UserDTO userDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
