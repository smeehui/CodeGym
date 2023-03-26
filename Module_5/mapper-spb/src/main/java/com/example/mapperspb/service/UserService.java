package com.example.mapperspb.service;

import com.example.mapperspb.mapper.UserMapper;
import com.example.mapperspb.model.User;
import com.example.mapperspb.model.dto.UserDTO;
import com.example.mapperspb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements GeneralService<UserDTO> {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDto(user);
    }

    @Override
    public void delete(UserDTO userDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
