package com.librarymanagement.components.book.controller;

import com.librarymanagement.components.book.model.Book;
import com.librarymanagement.components.book.model.BookItem;
import com.librarymanagement.components.book.service.BookFormatDAO;
import com.librarymanagement.components.book.service.BookItemDAO;
import com.librarymanagement.components.book.service.IBookFormatDAO;
import com.librarymanagement.components.book.service.IBookItemDAO;
import com.librarymanagement.components.user.services.BookTransactionDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Map;

@WebServlet(name = "BookItemServlet", value = "/book_item")
public class BookItemServlet extends HttpServlet {
    private BookTransactionDAO bookTransactionDAO;
    private IBookItemDAO bookItemDAO;
    private IBookFormatDAO bookFormatDAO;

    @Override
    public void init() throws ServletException {
        bookTransactionDAO = new BookTransactionDAO();
        bookItemDAO = new BookItemDAO();
        bookFormatDAO = new BookFormatDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        ServletContext context = request.getServletContext();
        context.setAttribute("bookFormats", bookFormatDAO.getAll());
        switch (action) {
            default -> showAllBookItems(request, response);
        }
    }

    private void showAllBookItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Long, BookItem> all = bookItemDAO.getAll();
        request.setAttribute("bookItems", all);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/table/all.jsp");
        request.setAttribute("view", "bookItem");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "add" -> addNewBookItem(request, response);
        }
    }

    private void addNewBookItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
        BookItem bookItem = validateBookItemDetails(request, errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form/add.jsp");
        if (errors.isEmpty()) {
            try {
                Book book = (Book) request.getAttribute("book");
                boolean status = bookTransactionDAO.addNewBookTransaction(book, bookItem);
                if (status) {
                    request.setAttribute("success", true);
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                errors.put("Lỗi database", e.getMessage());
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
        long bookID = (Long) request.getAttribute("bookId");
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
