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
import java.sql.Savepoint;

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
        Connection conn = null;
        boolean isBookSuccess = false;
        boolean isBookItemSuccess = false;
        try{
            conn = getConnection();
            conn.setAutoCommit(false);
            try {
                isBookSuccess =  bookDAO.add(book);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
            }
            Savepoint savepoint =  conn.setSavepoint();
            try {
               isBookItemSuccess =  bookItemDAO.add(bookItem);
                conn.commit();
            }catch (SQLException e) {
                conn.rollback(savepoint);
            }
            return (isBookItemSuccess && isBookSuccess);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            conn.close();
        }
    }
}
