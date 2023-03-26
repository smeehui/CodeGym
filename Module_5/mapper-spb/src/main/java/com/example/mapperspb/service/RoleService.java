package com.example.mapperspb.service;

import com.example.mapperspb.model.Role;
import com.example.mapperspb.model.dto.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements GeneralService<RoleDTO>{

    @Override
    public List<RoleDTO> getAll() {
        return null;
    }

    @Override
    public Optional<RoleDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        return null;
    }

    @Override
    public void delete(RoleDTO roleDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
