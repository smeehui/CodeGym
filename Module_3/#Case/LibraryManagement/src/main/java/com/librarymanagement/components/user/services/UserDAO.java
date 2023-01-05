package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDAO implements IUserDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "11111";

    private static final String SELECT_ALL_USER = "SELECT * FROM users";
    private static final String SELECT_ALL_EXIST_USER = "SELECT * FROM users WHERE users.deleted =false";

    private static final String SELECT_ALL_USER_ROLE = "SELECT * FROM roles";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";


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
    public Map<Integer, User> getAllExists() {
        Map<Integer, User> users = null;
        try (Connection connection = getConnection()) {
            users = new HashMap<>();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EXIST_USER);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = User.parseUser(rs);
                users.put(user.getId(), user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getUserRole(int id) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER_ROLE);
            statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getById(Integer integer) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return User.parseUser(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Map<Integer, User> getAll() {
        Map<Integer, User> users = new HashMap<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = User.parseUser(rs);
                users.put(user.getId(), user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void add(User newUser) {

    }

    @Override
    public void update(User newUser) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existById(long id) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public boolean existsByPhone(String phone) {
        return false;
    }

    @Override
    public boolean existsByUsername(String userName) {
        return false;
    }
}
