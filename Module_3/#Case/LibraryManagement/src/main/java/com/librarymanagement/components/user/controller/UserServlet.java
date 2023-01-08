package com.librarymanagement.components.user.controller;

import com.librarymanagement.components.user.models.User;
import com.librarymanagement.components.user.services.IUserDAO;
import com.librarymanagement.components.user.services.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
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
        String action = request.getParameter("action")==null?"":request.getParameter("action");
        switch (action) {
            case "add" -> showAddForm(request, response);
            case "edit" -> showEditForm(request, response);
            case "delete" -> deleteUser(request, response);
            default -> showAllUsers(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User user = userDAO.getById(id);
        if (user != null) {
            userDAO.deleteById(id);
        }
        response.sendRedirect("/user");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User user = userDAO.getById(id);
        request.setAttribute("view","user");
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/form/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "user");
        Map<Long, User> userMap = userDAO.getAllExists();
        request.setAttribute("users", userMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllActiveUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "user");
        Map<Long, User> userMap = userDAO.getAllExists();
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
        String action = request.getParameter("action")==null?"":request.getParameter("action");
        switch (action) {
            case "add" -> addNewUser(request, response);
        }
    }

    private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = System.currentTimeMillis() / 1000;
        String userFullName = request.getParameter("userFullName");
        String username = request.getParameter("username");
        String address = request.getParameter("userAddress");
        String password = request.getParameter("userPassword");
        String email = request.getParameter("userEmail");
        String phone = request.getParameter("userNumber");
        int role = Integer.parseInt(request.getParameter("role"));
        User user = new User(id, username, password, userFullName, phone, email, address, role, new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),false);
        boolean isSuccess = userDAO.add(user);
        response.sendRedirect("/user?action=all");
    }
}
