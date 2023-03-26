package com.example.mapperspb.controller.api;

import com.example.mapperspb.mapper.UserMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserApi {


    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
