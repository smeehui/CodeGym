package com.librarymanagement.services;

import com.librarymanagement.components.book.service.BookDAO;
import com.librarymanagement.components.book.service.IBookDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "BookItemFilter",value = "/book_item")
public class BookItemFilter implements Filter {
    IBookDAO bookDAO;
    public void init(FilterConfig config) throws ServletException {
        bookDAO = new BookDAO();
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setAttribute("books", bookDAO.getAllExists());
        request.setAttribute("view","bookItem");
        chain.doFilter(request, response);
    }
}
