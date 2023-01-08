package com.librarymanagement.components.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.Instant;

public class User {
    private long id;
    private String username;
    private String password;
    private String fullName;
    private String mobile;
    private String email;
    private String address;
    private int role;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean deleted;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public User() {
    }

    public User(Long id, String username, String password, String fullName, String mobile, String email, String address, int role, Instant createdAt, Instant updatedAt,boolean isDeleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted = isDeleted;
    }

    public static User parseUser(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String fullName = rs.getString("fullName");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String username = rs.getString("username");
        String password = rs.getString("password");
        Instant dateAdded = rs.getTimestamp("dateAdded").toInstant();
        Instant dateModified = rs.getTimestamp("dateModified").toInstant();
        int role = rs.getInt("role");
        Boolean isDeleted = rs.getBoolean("deleted");
        User user = new User(id,username,password,fullName,phone,email,address,role,dateAdded,dateModified,isDeleted);
        return user;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                id,
                username,
                password,
                fullName,
                mobile,
                email,
                address,
                role,
                createdAt,
                updatedAt
        );
    }
}
