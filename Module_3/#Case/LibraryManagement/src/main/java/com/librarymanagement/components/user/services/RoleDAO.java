package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.Role;
import jakarta.servlet.RequestDispatcher;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class RoleDAO implements IRoleDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";
    Map<Integer,Role> roles;
    private static final String SELECT_ALL_ROLE = "SELECT * FROM roles";
    private static final String GET_ROLE_BY_ID = "SELECT * FROM roles WHERE id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public Role getByID(int id) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) return Role.parse(rs);
            connection.close();
            preparedStatement.close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<Integer, Role> getAll() {
        try (Connection connection = getConnection()){
            roles = new HashMap<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROLE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Role role = Role.parse(rs);
                roles.put(role.getId(), role);
            }
            return roles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(Role newRole) {
        return false;
    }
}
