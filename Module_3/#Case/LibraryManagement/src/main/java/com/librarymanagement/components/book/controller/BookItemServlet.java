package com.librarymanagement.components.book.controller;

import com.librarymanagement.components.book.model.Book;
import com.librarymanagement.components.book.model.BookItem;
import com.librarymanagement.components.book.service.*;
import com.librarymanagement.components.user.services.BookTransactionDAO;
import com.librarymanagement.services.IAbstractService;
import com.librarymanagement.utils.RequestUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BookItemServlet", value = "/bookItem")
public class BookItemServlet extends HttpServlet {
    private BookTransactionDAO bookTransactionDAO;
    private IBookItemDAO bookItemDAO;
    private IBookFormatDAO bookFormatDAO;
    private IBookDAO bookDAO;
    private BookItemDOTDAO bookItemDOTDAO;
    private Map<String,String> errors;

    @Override
    public void init() throws ServletException {
        bookTransactionDAO = new BookTransactionDAO();
        bookItemDAO = new BookItemDAO();
        bookFormatDAO = new BookFormatDAO();
        bookDAO = new BookDAO();
        bookItemDOTDAO = new BookItemDOTDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        ServletContext context = request.getServletContext();
        context.setAttribute("bookFormats", bookFormatDAO.getAll());
        switch (action) {
            case "add"-> showAddForm(request, response);
            case "search"-> searchBookItem(request, response);
            case "delete" -> deleteBookItem(request, response);
            default -> showAllBookItems(request, response);
        }
    }

    private void searchBookItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestUtils.setPageAndAttributes(request,"search",bookItemDAO);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/form/add.jsp").forward(request, response);
    }

    private void showAllBookItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestUtils.setPageAndAttributes(request,"all",bookItemDOTDAO);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "add" -> addNewBookItemWithBook(request, response);
            case "edit"-> editBookItem(request, response);
            case "add_bookitem" -> addBookItemOnly(request, response);
        }
    }

    private void deleteBookItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        BookItem bookItem = bookItemDAO.getById(id);
        bookItem.setDeleted(!bookItem.isDeleted());
        try {
            bookItemDAO.update(bookItem);
        } catch (SQLException e) {
        }
        String url = RequestUtils.saveQuery(request);
        response.sendRedirect(url);
    }

    private void addBookItemOnly(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        errors =new HashMap<>();
        BookItem bookItem = validateBookItemDetails(request, errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/add.jsp");
        request.setAttribute("errors",errors);
        if (errors.isEmpty()) {
            Book book = bookDAO.getById(Long.parseLong(request.getParameter("bookId")));
            if (book != null) {
                try {
                    bookItemDAO.add(bookItem);
                    request.setAttribute("success", true);
                    dispatcher.forward(request, response);
                } catch (SQLException e) {
                    errors.put("database", e.getMessage());
                    request.setAttribute("bookItem", bookItem);
                    dispatcher.forward(request, response);
                }
            }else {
                errors.put("database", "Không tìm thấy sách tương ứng");
                request.setAttribute("bookItem", bookItem);
                dispatcher.forward(request, response);
            }
        }
    }

    private void editBookItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        errors = new HashMap<>();
        BookItem validatedBookItem = validateBookItemDetails(request, errors);
        long id = Long.parseLong(request.getParameter("id"));
        BookItem bookItem = bookItemDAO.getById(id);
        if (bookItem == null) {
            errors.put("ID sách mượn", "Không tìm thấy sách mượn tương ứng");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        if (errors.isEmpty()) {
            try {
                bookItemDAO.update(validatedBookItem);
                request.setAttribute("bookItems", bookItemDOTDAO.getAll());
            } catch (SQLException e) {
                errors.put("Database", e.getMessage());
                request.setAttribute("errors", errors);
                dispatcher.forward(request,response);
            }
            request.setAttribute("success",true);
            dispatcher.forward(request,response);
        }else {
            request.setAttribute("bookItems", bookItemDAO.getAll());
            request.setAttribute("errors", errors);
            dispatcher.forward(request, response);
        }
    }

    private void addNewBookItemWithBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        errors = request.getAttribute("errors")!=null? (Map<String, String>) request.getAttribute("errors"):new HashMap<>();
        BookItem bookItem = validateBookItemDetails(request, errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/add.jsp");
        if (errors.isEmpty()) {
            Book book = (Book) request.getAttribute("book");
            boolean status = false;
            try {
                status = bookTransactionDAO.addNewBookTransaction(book, bookItem);
            } catch (SQLException e) {
                errors.put("Lỗi database","Đã tồn tại sách mượn cho sách hiện tai, nhấn vào chỉnh sửa nếu bạn muốn thay đổi thông tin");
            }
            if (status) {
                request.setAttribute("success", true);
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errors", errors);
                request.setAttribute("bookItem", bookItem);
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("bookItem", bookItem);
            dispatcher.forward(request, response);
        }
    }

    private BookItem validateBookItemDetails(HttpServletRequest request, Map<String, String> errors) {
        BookItem bookItem;
        String idStr = request.getParameter("id");
        long id = 0;
        if (idStr == null) id = System.currentTimeMillis() / 1000;
        else try {
            id = Long.parseLong(idStr);
        } catch (Exception e) {
            errors.put("ID sai định dạng", "ID không đúng định dạng");
        }
        Date publishedDate = null;
        try {
            String bItemPublishedDateStr = request.getParameter("bItemPublishedDate");
            publishedDate = Date.valueOf(bItemPublishedDateStr);
        } catch (Exception e) {
            errors.put("Ngày sai định dạng", "Ngày không đúng định dạng");
        }
        int format = 1;
        try {
            format = Integer.parseInt(request.getParameter("bItemFormat"));
        } catch (Exception e) {
            errors.put("định dạng sách", "Định dạng sách không đúng");
        }
        String publisher = request.getParameter("bItemPublisher");

        int quantity = 0;
        try {
            quantity = Integer.parseInt(request.getParameter("bItemQuantity"));
            if (quantity > 999) errors.put("số lượng", "Số lượng quá lớn, vui lòng thử lại");
        } catch (Exception e) {
            errors.put("Số lượng", "Số lượng sai định dạng");
        }

        int numberOfPages = 0;
        try {
            numberOfPages = Integer.parseInt(request.getParameter("bItemPages"));
            if (numberOfPages > 21450) errors.put("số trang", "Số trang quá lớn, vui lòng nhập lại");
        } catch (Exception e) {
            errors.put("Số trang", "Số trang sai định dạng");
        }
        double price = 0;
        try {
            price = Double.parseDouble(request.getParameter("bItemPrice"));
            if (price > 100000) errors.put("giá mượn", "Giá mượn sách quá lớn, vui lòng nhập lại");
        } catch (Exception e) {
            errors.put("Giá", "Sai định dạng giá");
        }
        long bookID;
        try {
            bookID = (Long) request.getAttribute("bookId");
        } catch (Exception e) {
            bookID = Long.parseLong(request.getParameter("bookId"));
        }
        String dateAddedStr = request.getParameter("dateAdded");
        Instant dateAdded = Instant.now();
        if (dateAddedStr != null) try {
            dateAdded = Instant.parse(dateAddedStr);
        } catch (Exception e) {
            errors.put("Ngày thêm", "Ngày thêm sai định dạng");
        }
        Instant dateModified = Instant.now();
        boolean isAvailable = true;
        try {
            isAvailable = Boolean.parseBoolean(request.getParameter("bIAvailable"));
        } catch (Exception e) {
            errors.put("Tình trạng", "Trình trạng không đúng định dạng");
        }
        boolean deleted = false;
        bookItem = new BookItem(id, publishedDate, format, publisher, numberOfPages, price, bookID, quantity, dateAdded, dateModified, isAvailable, deleted);
        return bookItem;
    }
}
