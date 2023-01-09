package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDAO implements IUserDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";

    private static final String SELECT_ALL_USER = "SELECT * FROM users";
    private static final String SELECT_ALL_EXIST_USER = "SELECT * FROM users WHERE users.deleted =false";
    private static final String SELECT_ALL_USER_ROLE = "SELECT * FROM roles";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String INSERT_NEW_USER = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_BY_ID = "UPDATE users SET users.deleted = true WHERE users.id=?";
    private static final String UPDATE_USER_DETAILS = "UPDATE users SET fullName = ?,phone=?,email = ?,address=?,role=?,dateModified=? WHERE id =?";

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
    public Map<Long, User> getAllExists() {
        Map<Long, User> users = null;
        try (Connection connection = getConnection()) {
            users = new HashMap<>();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EXIST_USER);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = User.parseUser(rs);
                users.put(user.getId(), user);
            }
            statement.close();
            connection.close();
            return users;
        } catch (SQLException e) {
            errorLogger(e);
            return null;
        }
    }

    @Override
    public void getUserRole(int id) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER_ROLE);
            statement.executeQuery();
        } catch (SQLException e) {
            errorLogger(e);
        }
    }

    @Override
    public User getById(long id) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return User.parseUser(rs);
            }
            connection.close();
            statement.close();
            return null;
        } catch (SQLException e) {
            errorLogger(e);
            return null;
        }
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Map<Long, User> getAll() {
        Map<Long, User> users = new HashMap<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = User.parseUser(rs);
                users.put(user.getId(), user);
            }
            connection.close();
            preparedStatement.close();
            return users;
        } catch (SQLException e) {
            errorLogger(e);
            return null;
        }
    }

    private void errorLogger(SQLException e) {
        System.out.println(e.getErrorCode());
        System.out.println(e.getMessage());
    }

    @Override
    public boolean add(User newUser) throws SQLException {
        int rowAffected = 0;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
            preparedStatement.setLong(1, newUser.getId());
            preparedStatement.setString(2, newUser.getFullName());
            preparedStatement.setString(3, newUser.getAddress());
            preparedStatement.setString(4, newUser.getMobile());
            preparedStatement.setString(5, newUser.getEmail());
            preparedStatement.setString(6, newUser.getUsername());
            preparedStatement.setString(7, newUser.getPassword());
            preparedStatement.setInt(8, newUser.getRole());
            preparedStatement.setTimestamp(9, Timestamp.from(newUser.getCreatedAt()));
            preparedStatement.setTimestamp(10, Timestamp.from(newUser.getUpdatedAt()));
            preparedStatement.setBoolean(11, newUser.isDeleted());
            rowAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        return rowAffected > 0;
    }

    @Override
    public boolean update(User newUser) throws SQLException {
        //UPDATE users SET fullName = ?,phone=?,email = ?,address=?,role=?,dateModified=? WHERE id =?
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_DETAILS);
            preparedStatement.setString(1, newUser.getFullName());
            preparedStatement.setString(2, newUser.getMobile());
            preparedStatement.setString(3, newUser.getEmail());
            preparedStatement.setString(4, newUser.getAddress());
            preparedStatement.setInt(5, newUser.getRole());
            preparedStatement.setTimestamp(6, Timestamp.from(newUser.getUpdatedAt()));
            preparedStatement.setLong(7, newUser.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            int rowAffected = preparedStatement.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException e) {
            errorLogger(e);
            return false;
        }
    }

    @Override
    public boolean isDeleted(Long id) {
        return false;
    }
}
