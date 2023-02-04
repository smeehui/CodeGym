package com.smee.productmgmt;

import com.smee.productmgmt.category.Category;
import com.smee.productmgmt.category.CategoryDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "CategoryFilter",value = "/*")
public class CategoryFilter implements Filter {
    CategoryDAO categoryDAO;
    public void init(FilterConfig config) throws ServletException {
        categoryDAO = new CategoryDAO();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        List<Category> categories = categoryDAO.getAll();
        servletContext.setAttribute("categories", categories);
        chain.doFilter(request, response);
    }
}
