package huy.controller;

import huy.dao.IUserDAO;
import huy.dao.UserDAO;
import huy.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/")
public class UserServlet extends HttpServlet {
    IUserDAO userDAO;
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null) action="";
        switch (action) {
            case "add"-> showAddNewUserForm(request, response);
            case "edit"-> showEditForm(request,response);
            case "remove"-> removeUser(request,response);
            case "removed"-> showRemovedUsers(request, response);
            default -> showAllUsers(request, response);
        }
    }

    private void showRemovedUsers(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users",userDAO.selectRemovedUsers());
        request.setAttribute("view","removed");
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/all.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void removeUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userDAO.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/");
    }

    private void showRemoveConfirm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);
        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddNewUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/add.jsp");
        dispatcher.forward(request,response);
    }

    private void showAllUsers(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userDAO.selectAllUsers();
        request.setAttribute("users", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/all.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "add" -> addNewUser(request, response);
                case "edit"-> updateUser(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        boolean isSuccess = userDAO.updateUser(new User(id, name, email, country));
        response.sendRedirect("/");
    }

    private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        userDAO.insertUser(new User(id, name, email, country));
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
