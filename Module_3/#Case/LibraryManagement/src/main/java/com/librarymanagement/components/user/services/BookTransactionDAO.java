package com.librarymanagement.components.user.services;

import com.librarymanagement.components.book.model.Book;
import com.librarymanagement.components.book.model.BookItem;
import com.librarymanagement.components.book.service.BookDAO;
import com.librarymanagement.components.book.service.BookItemDAO;
import com.librarymanagement.components.book.service.IBookDAO;
import com.librarymanagement.components.book.service.IBookItemDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookTransactionDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/libdb";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Smee@99123";
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
    IBookDAO bookDAO;
    IBookItemDAO bookItemDAO;
    public BookTransactionDAO() {
        bookDAO = new BookDAO();
        bookItemDAO = new BookItemDAO();
    }
    public boolean addNewBookTransaction(Book book, BookItem bookItem) throws SQLException {
        boolean isBookSuccess;
        boolean isBookItemSuccess;
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);
            isBookSuccess = bookDAO.add(book);
            conn.commit();
            isBookItemSuccess = bookItemDAO.add(bookItem);
            conn.commit();
        }
        return (isBookItemSuccess && isBookSuccess);
    }
}
