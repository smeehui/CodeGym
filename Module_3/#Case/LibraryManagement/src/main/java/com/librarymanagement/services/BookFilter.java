package com.librarymanagement.services;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "BookFilter", value = "/book")
public class BookFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setAttribute("view", "book");
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
