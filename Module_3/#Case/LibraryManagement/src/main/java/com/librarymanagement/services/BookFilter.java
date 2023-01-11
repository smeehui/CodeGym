package com.librarymanagement.services;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "BookFilter", value = "/book*")
public class BookFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setAttribute("view", "book");
        chain.doFilter(request, response);
    }
}
