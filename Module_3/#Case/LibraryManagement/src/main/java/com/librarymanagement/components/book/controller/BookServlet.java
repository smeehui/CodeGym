package com.librarymanagement.components.book.controller;

import com.librarymanagement.components.book.model.Book;
import com.librarymanagement.components.book.service.BookDAO;
import com.librarymanagement.components.book.service.IBookDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
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
        String action = request.getParameter("action")==null?"":request.getParameter("action");
        switch (action) {
            case "add" -> showAddForm(request, response);
            case "delete"-> deleteBook(request, response);
            default -> showAllBook(request, response);
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        Book book = bookDAO.getById(id);
        if (book != null) {
           boolean status =  bookDAO.deleteById(id);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "book");
        RequestDispatcher dispatcher = request.getRequestDispatcher("form/add.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action")==null?"":request.getParameter("action");
        switch (action) {
            case "add"-> addNewUser(request, response);
        }

    }

    private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = System.currentTimeMillis() / 1000;
        String isbn = request.getParameter("isbn");
        String bookTitle = request.getParameter("bookTitle");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookLanguage = request.getParameter("bookLanguage");
        String bookSubject = request.getParameter("bookSubject");
        boolean isAvailable = Boolean.parseBoolean(request.getParameter("isAvailable"));
        boolean status = bookDAO.add(new Book(id,isbn,bookTitle,bookAuthor,bookSubject,bookLanguage,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),isAvailable,false));
        if (status) response.sendRedirect("/book");
    }
}
