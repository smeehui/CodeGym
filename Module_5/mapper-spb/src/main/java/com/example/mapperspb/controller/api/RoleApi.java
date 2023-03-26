package com.example.mapperspb.controller.api;

import com.example.mapperspb.model.dto.RoleDTO;
import com.example.mapperspb.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
public class RoleApi {
    RoleService roleService;

    public RoleApi(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody RoleDTO roleDTO){
        return new ResponseEntity<>(roleService.save(roleDTO),HttpStatus.OK);
    }
}
