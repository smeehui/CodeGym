package com.librarymanagement.components.book.service;

import com.librarymanagement.components.book.model.BookItem;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BookItemDAO implements IBookItemDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";
    private static final String SELECT_ALL_BOOKITEM = "SELECT SQL_CALC_FOUND_ROWS * FROM bookitems";
    private static final String INSERT_NEW_BOOKITEM = "INSERT INTO bookitems VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_BY_ID = "SELECT SQL_CALC_FOUND_ROWS * FROM bookitems WHERE id = ?";
    private static final String UPDATE_BOOKITEM = "UPDATE bookitems SET publishDate = ?, format = ?, publisher = ?, numberOfPages = ? , price = ? , bookId = ?, quantity = ?, dateAdded = ?, dateModified = ?, available = ?,deleted=? WHERE id = ?";
    private static final String SEARCH_BOOKITEM = "SELECT SQL_CALC_FOUND_ROWS * FROM bookitems WHERE (publisher LIKE ? OR title LIKE ? OR author LIKE ? OR subject LIKE ?)";
    private int gotRows = 0;
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
    public boolean updateQuantity() {
        return false;
    }

    @Override
    public Map<Long, BookItem> getAll() {
        return getBooks(SELECT_ALL_BOOKITEM);
    }
    private Map<Long, BookItem> getBooks(String query) {
        this.gotRows =0;
        Map<Long, BookItem> bookItems = new HashMap<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            PreparedStatement getRow = connection.prepareStatement("SELECT FOUND_ROWS()");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                this.gotRows++;
                BookItem bookItem = BookItem.parse(rs);
                bookItems.put(bookItem.getId(), bookItem);
            }
            ResultSet rows = getRow.executeQuery();
            while (rows.next()) this.noOfRecords = rows.getInt(1);
            preparedStatement.close();
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
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return BookItem.parse(rs);
            }
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
    public boolean update(BookItem bookItem) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKITEM);
            preparedStatement.setDate(1,bookItem.getPublishedDate());
            preparedStatement.setInt(2, bookItem.getFormat());
            preparedStatement.setString(3, bookItem.getPublisher());
            preparedStatement.setInt(4, bookItem.getNumberOfPages());
            preparedStatement.setDouble(5, bookItem.getPrice());
            preparedStatement.setLong(6, bookItem.getBookId());
            preparedStatement.setInt(7, bookItem.getQuantity());
            preparedStatement.setTimestamp(8, Timestamp.from(bookItem.getDateAdded()));
            preparedStatement.setTimestamp(9, Timestamp.from(bookItem.getDateModified()));
            preparedStatement.setBoolean(10, bookItem.isAvailable());
            preparedStatement.setBoolean(11, bookItem.isDeleted());
            preparedStatement.setLong(12, bookItem.getId());
            return preparedStatement.executeUpdate()>0;
        }
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
    public Map<Long, BookItem> search(String query, String condition) {
        String queryDB = SEARCH_BOOKITEM.replace("?", "'%"+query+"%'");
        if (condition!=null) queryDB += condition;
        return getBooks(queryDB);
    }

    @Override
    public int getNoOfRecords() {
        return this.noOfRecords;
    }

    @Override
    public Map<Long, BookItem> getPaging(String pageDetails, String condition) {
        String completedQuery;
        completedQuery = SELECT_ALL_BOOKITEM +condition + pageDetails;
        return getBooks(completedQuery);
    }

    @Override
    public int getGotRows() {
        return this.gotRows;
    }

    @Override
    public void setGotRow(int num) {
        this.gotRows = 0;
    }
}
