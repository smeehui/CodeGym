package com.librarymanagement.components.book.service;

import com.librarymanagement.components.book.model.Book;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookDAO implements IBookDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private Map<Long,Book> books;
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String SELECT_ALL_AVAILABLE_BOOKS = "SELECT * FROM books WHERE books.deleted=false";
    private static final String DELETE_BY_ID = "UPDATE books SET deleted = true WHERE books.id = ?";
    private static final String SELECT_BY_ID= "SELECT *FROM books WHERE books.id = ?";
    private static final String INSERT_NEW_BOOK = "INSERT INTO books VALUES (?,?,?,?,?,?,?,?,?,?)";

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
        return getBooks(SELECT_ALL_BOOKS);
    }

    private Map<Long, Book> getBooks(String selectAllBooks) {
        this.books = new HashMap<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(selectAllBooks);
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
    public Map<Long, Book> getAllExists() {
        return getBooks(SELECT_ALL_AVAILABLE_BOOKS);
    }

    @Override
    public Book getById(long id) {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return Book.parse(resultSet);
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public boolean add(Book book) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_BOOK);
            preparedStatement.setLong(1,book.getId());
            preparedStatement.setString(2,book.getIsbn());
            preparedStatement.setString(3,book.getTitle());
            preparedStatement.setString(4,book.getAuthor());
            preparedStatement.setString(5,book.getSubject());
            preparedStatement.setString(6,book.getLanguage());
            preparedStatement.setDate(7,book.getCreatedAt());
            preparedStatement.setDate(8,book.getUpdatedAt());
            preparedStatement.setBoolean(9,book.isAvailable());
            preparedStatement.setBoolean(10,book.isDeleted());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Book newEntity) {

    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setLong(1,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isDeleted(Long id) {
        Book book = getById(id);
        return book.isDeleted();
    }
}
