package com.librarymanagement.components.user.controller;

import com.librarymanagement.components.user.models.Role;
import com.librarymanagement.components.user.models.User;
import com.librarymanagement.components.user.services.IRoleDAO;
import com.librarymanagement.components.user.services.IUserDAO;
import com.librarymanagement.components.user.services.RoleDAO;
import com.librarymanagement.components.user.services.UserDAO;
import com.librarymanagement.utils.RequestUtils;
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
        request.setAttribute("view", "user");
        switch (action) {
            case "add" -> showAddForm(request, response);
            case "edit" -> showEditForm(request, response);
            case "delete" -> deleteUser(request, response);
            case "viewall" -> showUserDatabase(request, response);
            case "search" -> searchUser(request, response);
            default -> showAllUsers(request, response);
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestUtils.setPageAndAttributes(request,"search",userDAO);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        dispatcher.forward(request, response);
    }


    private void showUserDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Long, User> userMap = userDAO.getAll();
        request.setAttribute("users", userMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User user = userDAO.getById(id);
        if (user != null) {
            user.setDeleted(!user.isDeleted());
            user.setUpdatedAt(Instant.now());
            try {
                userDAO.update(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        response.sendRedirect("/user?action=viewall");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User user = userDAO.getById(id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer, Role> roleMap = roleDAO.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("roles", roleMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        RequestUtils.setPageAndAttributes(request, "all",userDAO);
        dispatcher.forward(request, response);
    }


    private void showAllActiveUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Long, User> userMap = userDAO.getAllExists();
        request.setAttribute("users", userMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/add.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        request.setAttribute("view", "user");
        switch (action) {
            case "add" -> addNewUser(request, response);
            case "edit" -> editUser(request, response);
            case "changePwd" -> changeUserPassword(request, response);
        }
    }

    private void changeUserPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<>();
        long id = Long.parseLong(request.getParameter("id"));
        User user = userDAO.getById(id);
        if (user == null) {
            errors.put("người dùng", "Không tìm thấy người dùng");
        }
        assert user != null;
        validatePassowrd(request, errors, user);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/edit.jsp");
        request.setAttribute("errors", errors);
        if (errors.isEmpty()) {
            user.setPassword(request.getParameter("newPassword"));
            try {
                boolean status = userDAO.update(user);
                request.setAttribute("success", true);
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                errors.put("dữ liệu", e.getMessage());
            }
        } else {
            dispatcher.forward(request, response);
        }
    }

    private void validatePassowrd(HttpServletRequest request, Map<String, String> errors, User user) {
        String curPwd = request.getParameter("password");
        String newPwd = request.getParameter("newPassword");
        String reNewPwd = request.getParameter("renewPassword");
        if (!ValidateUtils.isPasswordValid(curPwd)) errors.put("mật khẩu yếu", "Mật khẩu tối thiểu phải có 8 kí tự");
        else if (!(user.getPassword().equals(curPwd))) errors.put("mật khẩu không đúng", "Mật khẩu cũ không chính xác");
        else if (!ValidateUtils.isPasswordValid(newPwd))
            errors.put("mật khẩu yếu", "Mật khẩu tối thiểu phải có 8 kí tự");
        else if ((user.getPassword().equals(newPwd)))
            errors.put("mật khẩu bị trùng", "Mật khẩu bạn đã nhập là mật khẩu cũ");
        else if (!newPwd.equals(reNewPwd))
            errors.put("mật khẩu không khớp", "Mật khẩu nhập lại không khớp với mật khẩu mới");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<>();
        long id = Long.parseLong(request.getParameter("id"));
        User user = userDAO.getById(id);
        User updatedUser = validateUserDetails(request, errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/edit.jsp");
        request.setAttribute("view", "user");
        if (errors.isEmpty()) {
            try {
                boolean isSuccess = userDAO.update(updatedUser);
                request.setAttribute("user", userDAO.getById(id));
                if (isSuccess) {
                    request.setAttribute("success", true);
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
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
        if (message.contains("phone")) {
            type = "Số điện thoại đã tồn tại";
        } else if (message.contains("mail")) {
            type = "Email đã tồn tại";
        } else if (message.contains("username")) {
            type = "Tên người dùng đã tồn tại";
        } else type = message;
        errors.put("Lỗi dữ liệu", type);
    }


    private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> errors = new HashMap<>();
        User user = validateUserDetails(request, errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/add.jsp");
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
        User user = userDAO.getById(id);
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
        Instant dateAdded;
        if (dateAddedStr == null) {
            dateAdded = Instant.now();
        } else dateAdded = Instant.parse(dateAddedStr);
        Instant dateModified = Instant.now();
        boolean isDeleted = false;
        if (user != null) {
            username = user.getUsername();
            password = user.getPassword();
            isDeleted = user.isDeleted();
        }
        return new User(id, username, password, userFullName, phone, email, address, role, dateAdded, dateModified, isDeleted);
    }
}
