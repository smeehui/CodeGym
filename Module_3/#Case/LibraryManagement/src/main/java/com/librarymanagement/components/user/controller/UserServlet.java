package com.librarymanagement.components.user.controller;

import com.librarymanagement.components.user.models.Role;
import com.librarymanagement.components.user.models.User;
import com.librarymanagement.components.user.services.IRoleDAO;
import com.librarymanagement.components.user.services.IUserDAO;
import com.librarymanagement.components.user.services.RoleDAO;
import com.librarymanagement.components.user.services.UserDAO;
import com.librarymanagement.utils.ValidateUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "com.librarymanagement.components.user.controller.UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserDAO userDAO;
    private IRoleDAO roleDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        roleDAO = new RoleDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
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
        request.setAttribute("view", "user");
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "user");
        Map<Long, User> userMap = userDAO.getAllExists();
        Map<Integer, Role> roleMap = roleDAO.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("roles", roleMap);
        request.setAttribute("users", userMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllActiveUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "user");
        Map<Long, User> userMap = userDAO.getAllExists();
        request.setAttribute("users", userMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "user");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/add.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "add" -> addNewUser(request, response);
            case "edit" -> editUser(request, response);
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<>();
        long id = Long.parseLong(request.getParameter("id"));
        User user = userDAO.getById(id);
        User updatedUser = validateUserDetails(request, errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/edit.jsp");
        request.setAttribute("view","user");
        if (errors.isEmpty()) {
                try{
                    boolean isSuccess = userDAO.update(updatedUser);
                    request.setAttribute("user", userDAO.getById(id));
                    if (isSuccess) {
                        request.setAttribute("success", true);
                        dispatcher.forward(request, response);
                    }
                }catch (SQLException e){
                    request.setAttribute("user", user);
                    setMessageType(errors, e.getMessage());
                    dispatcher.forward(request, response);
                }
        } else {
            request.setAttribute("user", updatedUser);
            dispatcher.forward(request, response);
        }
    }

    private void setMessageType(Map<String, String> errors, String message) {
        String type = "";
        if (message.contains("phone")){
            type = "Số điện thoại đã tồn tại";
        } else if (message.contains("mail")) {
            type = "Email đã tồn tại";
        } else if (message.contains("username")) {
            type = "Tên người dùng đã tồn tại";
        }
        errors.put("Lỗi dữ liệu", type);
    }


    private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> errors = new HashMap<>();
        User user = validateUserDetails(request, errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/add.jsp");
        request.setAttribute("view", "user");
        if (errors.isEmpty()) {
            try {
                boolean isSuccess = userDAO.add(user);
                if (isSuccess) {
                    request.setAttribute("success", true);
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                for (Throwable throwable : e) {
                    setMessageType(errors, throwable.getMessage());
                }
                request.setAttribute("user", user);
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("user", user);
            dispatcher.forward(request, response);
        }
    }

    private User validateUserDetails(HttpServletRequest request, Map<String, String> errors) {
        String idStr = request.getParameter("id");
        long id;
        if (idStr != null) id = Long.parseLong(idStr);
        else id = System.currentTimeMillis() / 1000;
        request.setAttribute("errors", errors);
        String userFullName = request.getParameter("userFullName");
        if (!ValidateUtils.isFirstCaseValid(userFullName))
            errors.put("Họ và Tên", "Họ tên phải bắt đầu bằng kí tự in hoa và không có số hay ký tự đặc biệt");
        String username = request.getParameter("username");
        if (username != null && !ValidateUtils.isUsernameValid(username))
            errors.put("Tên người dùng", "Tên người dùng tối thiểu 4 ký tự và tối đa 20 ký tự, không có ký tự đặc biệt");
        String address = request.getParameter("userAddress");
        String password = request.getParameter("userPassword");
        if (password != null && !ValidateUtils.isPasswordValid(password))
            errors.put("Mật khấu", "Mật khẩu phải nhiều hơn 8 kí tự");
        String email = request.getParameter("userEmail");
        if (!ValidateUtils.isEmailValid(email))
            errors.put("Email", "Định dạng email chưa đúng, vui lòng thử lại");
        String phone = request.getParameter("userNumber");
        if (!ValidateUtils.isPhoneValid(phone))
            errors.put("Số điện thoại", "Số điện thoại bao gồm 10 số và bắt đầu là số 0");
        int role = Integer.parseInt(request.getParameter("role"));
        String dateAddedStr = request.getParameter("dateAdded");
        Instant dateAdded ;
        if (dateAddedStr == null) {
            dateAdded = Instant.now();
        } else dateAdded = Instant.parse(dateAddedStr);
        Instant dateModified = Instant.now();
        return new User(id, username, password, userFullName, phone, email, address, role, dateAdded, dateModified, false);
    }
}
