package com.librarymanagement.components.book.service;

import com.librarymanagement.components.book.model.Book;
import com.librarymanagement.components.user.models.User;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDAO implements IBookDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";

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
    public Book getByISBN(String isbn) {
        return null;
    }

    @Override
    public boolean existByISBN(String isbn) {
        return false;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return null;
    }

    @Override
    public Map<Long, Book> getAll() {
        Map<Long, Book> books = new HashMap<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = Book.parse(rs);
                books.put(book.getId(), book);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Map<Long, User> getAllExists() {
        return null;
    }

    @Override
    public Object getById(long o) {
        return null;
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public boolean add(Object newEntity) {

        return false;
    }

    @Override
    public void update(Object newEntity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
