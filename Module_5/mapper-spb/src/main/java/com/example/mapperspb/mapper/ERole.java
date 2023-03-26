package com.example.mapperspb.mapper;

public enum ERole {
    ADMIN("ADMIN"),
    USER("USER");

    private String value;

    ERole(String value) {
        this.value = value;
    }

    ERole() {
    }

    public String getValue() {
        return value;
    }
}
