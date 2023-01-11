package com.librarymanagement.components.book.service;

import com.librarymanagement.components.book.model.Book;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookDAO implements IBookDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";
    private static final String UPDATE_BOOK = "UPDATE books SET isbn = ?,title = ? ,author = ?,subject = ?,language = ?,dateAdded = ?,dateModified =?,available = ? WHERE id = ? ";
    private static final String SELECT_ALL_BOOKS = "SELECT SQL_CALC_FOUND_ROWS * FROM books";
    private static final String SELECT_ALL_AVAILABLE_BOOKS = "SELECT * FROM books WHERE books.deleted=false ORDER BY books.title ASC";
    private static final String DELETE_BY_ID = "UPDATE books SET deleted = true WHERE books.id = ?";
    private static final String SELECT_BY_ID= "SELECT *FROM books WHERE books.id = ?";
    private static final String INSERT_NEW_BOOK = "INSERT INTO books VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SEARCH_BOOK = "SELECT SQL_CALC_FOUND_ROWS * FROM books WHERE (isbn LIKE ? OR title LIKE ? OR author LIKE ? OR subject LIKE ?)";

    private int noOfRecords = 0;
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
        Map<Long, Book> books = new HashMap<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(selectAllBooks);
             PreparedStatement getRow = connection.prepareStatement("SELECT FOUND_ROWS()");
            ResultSet rs = preparedStatement.executeQuery();
            long count = 0;
            while (rs.next()) {
                Book book = Book.parse(rs);
                books.put(count++, book);
              }
             ResultSet rows = getRow.executeQuery();
            while (rows.next()) this.noOfRecords = rows.getInt(1);
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
    public boolean add(Book book) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_BOOK);
            preparedStatement.setLong(1,book.getId());
            preparedStatement.setString(2,book.getIsbn().replace("_",""));
            preparedStatement.setString(3,book.getTitle());
            preparedStatement.setString(4,book.getAuthor());
            preparedStatement.setString(5,book.getSubject());
            preparedStatement.setString(6,book.getLanguage());
            preparedStatement.setTimestamp(7,Timestamp.from(book.getCreatedAt()));
            preparedStatement.setTimestamp(8,Timestamp.from(book.getUpdatedAt()));
            preparedStatement.setBoolean(9,book.isAvailable());
            preparedStatement.setBoolean(10,book.isDeleted());
            int rowAffected = preparedStatement.executeUpdate();
            return rowAffected > 0;
        }
    }

    @Override
    public boolean update(Book book) {
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_BOOK);
            //UPDATE books SET isbn = ?,title = ? ,author = ?,subject = ?,language = ?,dateAdded = ?,dateModified =?,available = ? WHERE id = ?
            preparedStatement.setString(1, book.getIsbn().replace("-",""));
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setString(4,book.getSubject());
            preparedStatement.setString(5,book.getLanguage());
            preparedStatement.setTimestamp(6,Timestamp.from(book.getCreatedAt()));
            preparedStatement.setTimestamp(7,Timestamp.from(book.getUpdatedAt()));
            preparedStatement.setBoolean(8,book.isAvailable());
            preparedStatement.setLong(9,book.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setLong(1,id);
            boolean hasSuccess = preparedStatement.executeUpdate() > 0;
            return hasSuccess;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isDeleted(Long id) {
        Book book = getById(id);
        return book.isDeleted();
    }

    @Override
    public Map<Long, Book> search(String query, String condition) {
        String queryDB = SEARCH_BOOK.replace("?", "'%"+query+"%'");
        if (condition!=null) queryDB += condition;
        return getBooks(queryDB);
    }

    @Override
    public int getNoOfRecords() {
        return noOfRecords;
    }

    @Override
    public Map<Long, Book> getPaging(String pageDetails, String condition) {
        String completedQuery;
        completedQuery = SELECT_ALL_BOOKS +condition + pageDetails;
        return getBooks(completedQuery);
    }
}
