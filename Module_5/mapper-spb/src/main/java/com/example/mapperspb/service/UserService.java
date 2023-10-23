package com.example.mapperspb.service;

import com.example.mapperspb.mapper.RoleMapper;
import com.example.mapperspb.mapper.UserMapper;
import com.example.mapperspb.model.Role;
import com.example.mapperspb.model.User;
import com.example.mapperspb.model.dto.RoleDTO;
import com.example.mapperspb.model.dto.UserDTO;
import com.example.mapperspb.repository.RoleRepository;
import com.example.mapperspb.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements GeneralService<UserDTO> {
    private final UserRepository userRepository;

    private final RoleRepository repository;

    private final RoleMapper roleMapper;
    private final UserMapper userMapper;

    private final ModelMapper  modelMapper;

    public UserService(UserRepository userRepository, RoleRepository repository, RoleMapper roleMapper, UserMapper userMapper, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.repository = repository;
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
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
    @Transactional
    public UserDTO save(UserDTO dto) {
        List<Role> subEntities = getSubEntities(dto);
        User entity = userMapper.toEntity(dto);
        entity.setRoles(subEntities);
        User user = userRepository.save(entity);
        return userMapper.toDto(user);
    }

    private List<Role> getSubEntities(UserDTO dto) {
        List<Role> subEntities = new ArrayList<>();
        for (RoleDTO subDto : dto.getRoles()) {
            subEntities.add(repository.findByRole(subDto.getRole()));
        }
        return subEntities;
    }

    @Override
    public void delete(UserDTO userDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }

    public List<UserDTO> findAllWithMp() {
        return userRepository.findAll()
                .stream().map(user -> modelMapper.map(user,UserDTO.class))
                .collect(Collectors.toList());
    }
}
