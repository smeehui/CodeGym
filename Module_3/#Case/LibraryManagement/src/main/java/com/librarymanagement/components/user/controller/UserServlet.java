package com.librarymanagement.components.user.controller;

import com.librarymanagement.components.user.models.User;
import com.librarymanagement.components.user.services.IUserDAO;
import com.librarymanagement.components.user.services.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "com.librarymanagement.components.user.controller.UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add" -> showAddForm(request, response);
            case "all" -> showAllUsers(request, response);
        }
    }

    private void showAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "user");
        Map<Integer, User> userMap = userDAO.getAll();
        request.setAttribute("users", userMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllActiveUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "user");
        Map<Integer, User> userMap = userDAO.getAllExists();
        request.setAttribute("users", userMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "user");
        RequestDispatcher dispatcher = request.getRequestDispatcher("form/add.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
