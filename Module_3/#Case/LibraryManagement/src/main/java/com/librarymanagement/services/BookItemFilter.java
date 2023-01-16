package com.librarymanagement.services;

import com.librarymanagement.components.book.service.BookDAO;
import com.librarymanagement.components.book.service.BookFormatDAO;
import com.librarymanagement.components.book.service.IBookDAO;
import com.librarymanagement.components.book.service.IBookFormatDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "BookItemFilter",value = "/bookItem")
public class BookItemFilter implements Filter {
    IBookDAO bookDAO;
    IBookFormatDAO bookFormatDAO;
    public void init(FilterConfig config) throws ServletException {
        bookDAO = new BookDAO();
        bookFormatDAO = new BookFormatDAO();
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setAttribute("books", bookDAO.getAll());
        request.setAttribute("bookFormats", bookFormatDAO.getAll());
        request.setAttribute("view","bookItem");
        chain.doFilter(request, response);
    }
}
