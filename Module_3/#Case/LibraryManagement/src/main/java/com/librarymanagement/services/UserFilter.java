package com.librarymanagement.services;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "UserFilter", urlPatterns = "/user*")
public class UserFilter implements jakarta.servlet.Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setAttribute("view", "user");
        chain.doFilter(request, response);
    }
}
