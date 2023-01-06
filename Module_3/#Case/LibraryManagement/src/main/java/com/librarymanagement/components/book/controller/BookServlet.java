package com.librarymanagement.components.book.controller;

import com.librarymanagement.components.book.model.Book;
import com.librarymanagement.components.book.service.BookDAO;
import com.librarymanagement.components.book.service.IBookDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
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
        String action = request.getParameter("action");
        switch (action) {
            case "all" -> showAllBook(request, response);
            case "add" -> showAddForm(request, response);
        }
    }

    private void showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Long, Book> books = bookDAO.getAll();
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

    }
}
