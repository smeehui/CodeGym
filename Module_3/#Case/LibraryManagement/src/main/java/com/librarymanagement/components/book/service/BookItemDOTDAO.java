package com.librarymanagement.components.book.service;

import com.librarymanagement.components.book.model.BookItemDOT;
import com.librarymanagement.services.IAbstractService;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BookItemDOTDAO implements IAbstractService<BookItemDOT, Long> {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";
    private static final String SEARCH_BOOK_ITEM = "SELECT SQL_CALC_FOUND_ROWS bi.id,b.title,bi.bookId,bi.publishDate,bf.name AS format ,bi.publisher,bi.numberOfPages,bi.price,bi.quantity,bi.dateAdded,bi.dateAdded,bi.dateModified,bi.available,bi.deleted FROM bookitems bi JOIN bookitemformat bf on bf.id = bi.format JOIN books b on b.id = bi.bookId WHERE (bi.id LIKE ? OR b.title LIKE ? OR\n" +
                                                   "bf.name LIKE ? OR  bi.publisher LIKE ? OR bi.numberOfPages LIKE ? OR bi.price LIKE ? OR bi.quantity LIKE ?)";
    private Map<Long,BookItemDOT> bookItemDOTMap;
    private static final String SELECT_ALL_BOOKITEM_DOT = "SELECT SQL_CALC_FOUND_ROWS bi.id,b.title,bi.bookId,bi.publishDate,bf.name AS format ,bi.publisher,bi.numberOfPages,bi.price,bi.quantity,bi.dateAdded,bi.dateAdded,bi.dateModified,bi.available,bi.deleted FROM bookitems bi JOIN bookitemformat bf on bf.id = bi.format JOIN books b on b.id = bi.bookId";
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
    public Map<Long, BookItemDOT> getAll() {
       return getBookItems(SELECT_ALL_BOOKITEM_DOT);
    }

    private Map<Long, BookItemDOT> getBookItems(String query) {
        bookItemDOTMap = new HashMap<>();
        this.gotRows =0;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            PreparedStatement getRow = connection.prepareStatement("SELECT FOUND_ROWS()");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                this.gotRows++;
                BookItemDOT bookItem = BookItemDOT.parse(rs);
                bookItemDOTMap.put(bookItem.getId(), bookItem);
            }
            ResultSet rows = getRow.executeQuery();
            while (rows.next()) this.noOfRecords = rows.getInt(1);
            preparedStatement.close();
            return bookItemDOTMap;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<Long, BookItemDOT> getAllExists() {
        return null;
    }

    @Override
    public BookItemDOT getById(long id) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public boolean add(BookItemDOT newEntity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BookItemDOT newEntity) throws SQLException {
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
    public Map<Long, BookItemDOT> search(String query, String condition) {
        String queryDB = SEARCH_BOOK_ITEM.replace("?", "'%"+query+"%'");
        if (condition!=null) queryDB += condition.replace("deleted","bi.deleted");
        return getBookItems(queryDB);
    }

    @Override
    public int getNoOfRecords() {
        return this.noOfRecords;
    }

    @Override
    public Map<Long, BookItemDOT> getPaging(String pageDetails, String condition) {
        String completedQuery;
        condition = condition.replace("deleted", "bi.deleted");
        completedQuery = SELECT_ALL_BOOKITEM_DOT +condition + pageDetails;
        return getBookItems(completedQuery);
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
