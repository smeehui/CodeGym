package com.librarymanagement.components.book.controller;

import com.librarymanagement.components.book.model.BookItem;
import com.librarymanagement.components.book.service.BookItemDAO;
import com.librarymanagement.components.book.service.IBookDAO;
import com.librarymanagement.components.book.service.IBookItemDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BookItemServlet", value = "/book_item")
public class BookItemServlet extends HttpServlet {

    private IBookItemDAO bookItemDAO;

    @Override
    public void init() throws ServletException {
        bookItemDAO = new BookItemDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
        }
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
                boolean status = bookItemDAO.add(bookItem);
                if (status) {
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                errors.put("Lỗi database", e.getMessage());
                request.setAttribute("bookItem",bookItem);
                dispatcher.forward(request,response);
            }
        }else {
            request.setAttribute("bookItem",bookItem);
            dispatcher.forward(request,response);
        }
    }

    private BookItem validateBookItemDetails(HttpServletRequest request, Map<String, String> errors) {
        BookItem bookItem;
        String  idStr = request.getParameter("id");
        long id = 0;
        if (idStr==null) id = System.currentTimeMillis();
        else try {
            id = Long.parseLong(idStr);
        } catch (Exception e) {
            errors.put("ID sai định dạng", "ID không đúng định dạng");
        }
        Date publishedDate = new Date(System.currentTimeMillis());
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
        int numberOfPages = 0;
        try {
            numberOfPages = Integer.parseInt(request.getParameter("bItemPages"));
        } catch (Exception e) {
            errors.put("Số trang", "Số trang sai định dạng");
        }
        double price =0;
        try {
            price = Double.parseDouble(request.getParameter("bItemPrice"));
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
        bookItem =  new BookItem(id, publishedDate, format, publisher, numberOfPages, price, bookID, dateAdded, dateModified, isAvailable, deleted);
        return bookItem;
    }
}
