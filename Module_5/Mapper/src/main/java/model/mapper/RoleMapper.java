package model.mapper;

import model.dto.RoleDTO;

public class RoleMapper {
    private static RoleMapper INSTANCE;

    public static RoleMapper getINSTANCE() {
        return INSTANCE;
    }
    public static RoleMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RoleMapper();
        }
        return INSTANCE;
    }

    public Role toEntity (RoleDTO dto){
       Role role = new Role();
       role.setRole(dto.getRole());
       return role;
    }

    public RoleDTO toDto (Role role){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRole(role.getRole());
        return roleDTO;
    }
}
