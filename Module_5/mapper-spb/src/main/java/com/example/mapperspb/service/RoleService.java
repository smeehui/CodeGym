package com.example.mapperspb.service;

import com.example.mapperspb.mapper.RoleMapper;
import com.example.mapperspb.model.Role;
import com.example.mapperspb.model.dto.RoleDTO;
import com.example.mapperspb.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements GeneralService<RoleDTO>{
    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> findAll() {
        return null;
    }

    @Override
    public Optional<RoleDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        Role role = roleRepository.save(roleMapper.toEntity(roleDTO));
        return roleMapper.toDto(role);
    }

    @Override
    public void delete(RoleDTO roleDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
