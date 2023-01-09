package com.librarymanagement.components.book.controller;

import com.librarymanagement.components.book.model.Book;
import com.librarymanagement.components.book.service.BookDAO;
import com.librarymanagement.components.book.service.IBookDAO;
import com.librarymanagement.utils.ValidateUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    IBookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "add" -> showAddForm(request, response);
            case "delete" -> deleteBook(request, response);
            case "edit" -> showEditBookForm(request, response);
            default -> showAllBook(request, response);
        }
    }

    private void showEditBookForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = bookDAO.getById(Long.parseLong(request.getParameter("id")));
        if (book != null) {
            request.setAttribute("book", book);
            request.setAttribute("view", "book");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/form/edit.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        Book book = bookDAO.getById(id);
        if (book != null) {
            boolean status = bookDAO.deleteById(id);
        }
        try {
            response.sendRedirect("/book?action=all");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Long, Book> books = bookDAO.getAllExists();
        request.setAttribute("view", "book");
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "book");
        request.setAttribute("errors", new HashMap<String, String>());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/add.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "add" -> addNewBook(request, response);
            case "edit" -> editBook(request, response);
        }

    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> errors = new HashMap<>();
        Book book = validateBookDetails(request, errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/edit.jsp");
        request.setAttribute("view","book");
        if (errors.isEmpty()) {
            try{
                boolean isSuccess = bookDAO.update(book);
                if (isSuccess) {
                    request.setAttribute("book", bookDAO.getById(book.getId()));
                    request.setAttribute("success", true);
                    dispatcher.forward(request, response);
                }
            }catch (SQLException e){
                request.setAttribute("book", book);
                setMessageType(errors, e.getMessage());
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("book", book);
            request.setAttribute("success",true);
            dispatcher.forward(request, response);
        }
    }

    private void setMessageType(Map<String, String> errors, String message) {
        String type = "";
        if (message.contains("isbn")) {
            type = "ISBN đã tồn tại";
        } else if (message.contains("id")) {
            type = "ID đã tồn tại";
        }
        errors.put("Lỗi dữ liệu", type);
    }

    private Book validateBookDetails(HttpServletRequest request, Map<String, String> errors) {
        request.setAttribute("errors", errors);
        long id;
        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (NumberFormatException e) {
            id = System.currentTimeMillis() / 1000;
        }
        String isbn = request.getParameter("isbn");
        if (!ValidateUtils.isIsbnValid(isbn)) errors.put("ISN", "ISBN không hợp lệ, ISBN phải là 10 số và có định dạng 1234567890 hoặc 1-234-56789-0)");
        String bookTitle = request.getParameter("bookTitle");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookLanguage = request.getParameter("bookLanguage");
        String bookSubject = request.getParameter("bookSubject");
        String dateAddedStr = request.getParameter("dateAdded") == null ? Instant.now().toString() : request.getParameter("dateAdded");
        Instant dateAdded = Instant.parse(dateAddedStr);
        Instant dateModified = Instant.now();
        boolean isAvailable = Boolean.parseBoolean(request.getParameter("isAvailable"));
        boolean isDeleted = Boolean.parseBoolean(request.getParameter("isDeleted"));
        return new Book(id, isbn, bookTitle, bookAuthor, bookSubject,bookLanguage, dateAdded, dateModified, isAvailable, isDeleted);
    }

    private void addNewBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> errors = new HashMap<>();
        Book book = validateBookDetails(request, errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("//WEB-INF/form/add.jsp");
        request.setAttribute("view", "book");
        if (errors.isEmpty()) {
           try {
               boolean status = bookDAO.add(book);
               if (status) {
                   request.setAttribute("success", true);
                   dispatcher.forward(request, response);
               }
           } catch (SQLException e) {
               errors.put("Lỗi dữ liệu", e.getMessage());
               request.setAttribute("book", book);
               dispatcher.forward(request, response);
           }
        } else {
            request.setAttribute("book", book);
            dispatcher.forward(request, response);
        }
    }
}
