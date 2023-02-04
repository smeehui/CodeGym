package com.librarymanagement.components.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Role {
    private int id;
    private String name;

    public Role() {
    }

    public static Role parse(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Role(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
