package com.librarymanagement.components.book.service;

import com.librarymanagement.components.book.model.BookFormat;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BookFormatDAO implements IBookFormatDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";
    private static final String GET_ALL_BOOK_FORMATS = "SELECT * FROM bookitemformat";

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
    public Map<Integer, BookFormat> getAll() {
        Map<Integer, BookFormat> bookFormatMap;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BOOK_FORMATS);
            ResultSet resultSet = preparedStatement.executeQuery();
            bookFormatMap  =  new HashMap<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                BookFormat bookFormat = BookFormat.parserBookFormat(id);
                bookFormatMap.put(id, bookFormat);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookFormatMap;
    }

    @Override
    public Map<Integer, BookFormat> getAllExists() {
        return null;
    }

    @Override
    public BookFormat getById(long id) {
        return null;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public boolean add(BookFormat newEntity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BookFormat newEntity) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean isDeleted(Long id) {
        return false;
    }

    @Override
    public Map<Integer, BookFormat> search(String query, String s) {
        return null;
    }

    @Override
    public int getNoOfRecords() {
        return 0;
    }

    @Override
    public Map<Integer, BookFormat> getPaging(String pageDetails, String condition) {
        return null;
    }
}
