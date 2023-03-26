package com.example.mapperspb.controller.api;

import com.example.mapperspb.mapper.UserMapper;
import com.example.mapperspb.model.dto.UserDTO;
import com.example.mapperspb.service.UserService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserApi {
    UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO){

        return new ResponseEntity<>(userService.save(userDTO),HttpStatus.OK);
    }
}
