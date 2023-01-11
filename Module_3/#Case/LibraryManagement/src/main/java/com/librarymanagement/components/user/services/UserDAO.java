package com.librarymanagement.components.user.services;

import com.librarymanagement.components.user.models.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDAO implements IUserDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";

    private static final String SELECT_ALL_USER = "SELECT SQL_CALC_FOUND_ROWS * FROM users";
    private static final String SELECT_ALL_EXIST_USER = "SELECT * FROM users WHERE users.deleted =false";
    private static final String SELECT_ALL_USER_ROLE = "SELECT * FROM roles";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String INSERT_NEW_USER = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_BY_ID = "UPDATE users SET users.deleted = true WHERE users.id=?";
    private int noOfRecords = 0;
    private static final String UPDATE_USER_DETAILS = "UPDATE users SET " +
                                  "fullName=?,address=?,phone=?,email=?,username=?, password=?, role=?,dateAdded=?," +
                                  "dateModified=?,deleted=? "+
                                  "WHERE id=?";
    private static final String SEARCH_USER = "SELECT SQL_CALC_FOUND_ROWS * FROM users WHERE (fullName LIKE ? OR address LIKE ? OR phone LIKE ? OR email LIKE ?)";

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
        return getUsers(SELECT_ALL_EXIST_USER);
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
        } catch (SQLException e) {
            errorLogger(e);
        }
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Map<Long, User> getAll() {
        return getUsers(SELECT_ALL_USER);
    }

    private Map<Long, User> getUsers(String query) {
        Map<Long, User> users = new HashMap<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            PreparedStatement getRow = connection.prepareStatement("SELECT FOUND_ROWS()");
            while (rs.next()) {
                User user = User.parseUser(rs);
                users.put(user.getId(), user);
            }
            ResultSet rows = getRow.executeQuery();
            while (rows.next())this.noOfRecords = rows.getInt(1);
            connection.close();
            preparedStatement.close();
            return users;
        } catch (SQLException e) {
            errorLogger(e);
            return null;
        }
    }

    public int getNoOfRecords() {
        return noOfRecords;
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
//        "fullName=?,address=?,phone=?,email = ?,username = ?, password=?, role=?,dateAdded=?" +
//        "dateModified=?,deleted=?"+
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_DETAILS);
            preparedStatement.setString(1, newUser.getFullName());
            preparedStatement.setString(2, newUser.getAddress());
            preparedStatement.setString(3, newUser.getMobile());
            preparedStatement.setString(4, newUser.getEmail());
            preparedStatement.setString(5, newUser.getUsername());
            preparedStatement.setString(6, newUser.getPassword());
            preparedStatement.setInt(7, newUser.getRole());
            preparedStatement.setTimestamp(8, Timestamp.from(newUser.getCreatedAt()));
            preparedStatement.setTimestamp(9, Timestamp.from(newUser.getUpdatedAt()));
            preparedStatement.setBoolean(10,newUser.isDeleted());
            preparedStatement.setLong(11, newUser.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public Map<Long, User> getPaging(String pageDetails, String condition) {
        String completedQuery;
        completedQuery = SELECT_ALL_USER +condition + pageDetails;
        return getUsers(completedQuery);
    }
    public int getRow(ResultSet rs) throws SQLException {
        return rs.getInt(1);
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
    @Override
    public Map<Long, User> search(String query, String condition) {
        String queryDB = SEARCH_USER.replace("?", "'%"+query+"%'");
        if (condition!=null) queryDB += condition;
        return getUsers(queryDB);
    }

}
