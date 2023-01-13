package com.librarymanagement.components.book.service;

import com.librarymanagement.components.book.model.BookItem;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BookItemDAO implements IBookItemDAO{
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";
    private static final String SELECT_ALL_BOOKITEM = "SELECT * FROM bookitems";
    private static final String INSERT_NEW_BOOKITEM = "INSERT INTO bookitems VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

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
    public boolean updateQuantity() {
        return false;
    }

    @Override
    public Map<Long, BookItem> getAll() {
        return getBooks(SELECT_ALL_BOOKITEM);
    }
    private Map<Long, BookItem> getBooks(String query) {
        Map<Long, BookItem> bookItems = new HashMap<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            long count = 0;
            while (rs.next()) {
                BookItem bookItem = BookItem.parse(rs);
                bookItems.put(count++, bookItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookItems;
    }
    @Override
    public Map<Long, BookItem> getAllExists() {
        return null;
    }

    @Override
    public BookItem getById(long id) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public boolean add(BookItem bookItem) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_BOOKITEM);
            preparedStatement.setLong(1,bookItem.getId());
            preparedStatement.setDate(2,bookItem.getPublishedDate());
            preparedStatement.setInt(3,bookItem.getFormat());
            preparedStatement.setString(4,bookItem.getPublisher());
            preparedStatement.setInt(5,bookItem.getNumberOfPages());
            preparedStatement.setDouble(6, bookItem.getPrice());
            preparedStatement.setLong(7,bookItem.getBookId());
            preparedStatement.setInt(8,bookItem.getQuantity());
            preparedStatement.setTimestamp(9,Timestamp.from(bookItem.getDateAdded()));
            preparedStatement.setTimestamp(10,Timestamp.from(bookItem.getDateModified()));
            preparedStatement.setBoolean(11,bookItem.isAvailable());
            preparedStatement.setBoolean(12,bookItem.isDeleted());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(BookItem newEntity) throws SQLException {
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
    public Map<Long, BookItem> search(String query, String s) {
        return null;
    }

    @Override
    public int getNoOfRecords() {
        return 0;
    }

    @Override
    public Map<Long, BookItem> getPaging(String pageDetails, String condition) {
        return null;
    }

    @Override
    public int getGotRows() {
        return 0;
    }

    @Override
    public void setGotRow(int num) {

    }
}
