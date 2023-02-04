package com.smee.productmgmt.product;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smee.productmgmt.category.CategoryDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private Map<String,String> errors;


    public void init() {
        productDAO = new ProductDAO();
        categoryDAO= new CategoryDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.getServletContext().setAttribute("categories", categoryDAO.getAll());
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "delete"-> deleteProduct(request, response);
            case "add" -> showAddForm(request, response);
            case "edit" -> showEditProductForm(request, response);
            default -> showAllProduct(request,response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        errors = new HashMap<>();
        String idStr = request.getParameter("id");
        request.setAttribute("errors", errors);
        int id=0;
        try {
            id = Integer.parseInt(idStr);
        } catch (Exception e) {
            errors.put("ID sản phẩm", "ID sản phẩm sai");
        }
        try {
            productDAO.delete(id);
            response.sendRedirect("/product");
        } catch (SQLException e) {
            errors.put("cơ sở dữ liệu", "Xáy ra lỗi với cơ sở dữ liệu");
            request.getRequestDispatcher("/WEB-INF/product/products.jsp");
        }
    }

    private void showEditProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        errors = new HashMap<>();
        request.setAttribute("errors",errors);
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            errors.put("id sản phẩm", "sai id sản phẩm");
        }
        Product product = null;
        try {
            product = productDAO.getById(id);
        } catch (SQLException e) {
            errors.put("dữ liệu", "Xảy ra lỗi với dữ liệu người dùng");
        }
        if (product == null) {
            errors.put("sản phẩm", "Không tìm thấy sản phẩm");
        }
        if (errors.isEmpty()) {
            request.setAttribute("product",product);
            request.getRequestDispatcher("/WEB-INF/product/edit.jsp").forward(request, response);
        }else response.sendRedirect("/product");
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/product/add.jsp").forward(request,response);
    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products;
        String q = request.getParameter("q");
        if (q == null) {
            products= productDAO.getAll();
        }else products = productDAO.searchByName(q);
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/product/products.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case"edit"-> editProduct(request, response);
            case "add" -> addNewProd(request, response);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        errors = new HashMap<>();
        Product product = validateProductDetails(request);
        int id = Integer.parseInt(request.getParameter("id"));
        if (errors.isEmpty()) {
            product.setId(id);
            try {
                productDAO.update(product);
                response.sendRedirect("/product");
            } catch (SQLException e) {
                errors.put("cở sở dữ liệu", e.getMessage());
                request.setAttribute("product", product);
                request.getRequestDispatcher("/WEB-INF/product/edit.jsp");
            }
        }else {
            request.setAttribute("product",product);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/product/edit.jsp").forward(request, response);
        }
    }

    private void addNewProd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Product product = validateProductDetails(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/add.jsp");
        request.setAttribute("product", product);
        if (errors.isEmpty()) {
            try {
                productDAO.addNew(product);
                response.sendRedirect("/product");
            } catch (SQLException e) {
                errors.put("cơ sở dữ liệu", e.getMessage());
            }
        }else {
            dispatcher.forward(request, response);
        }
    }

    private Product validateProductDetails(HttpServletRequest request) {
        errors = new HashMap<>();
        request.setAttribute("errors",errors);
        String pName = request.getParameter("name");
        double pPrice = 0;
        try {
            pPrice = Double.parseDouble(request.getParameter("price"));
            if (pPrice > 1000000000 || pPrice < 10000) {
                errors.put("giá sản phẩm","Giá sản phẩm trong khoảng từ 10000 - 1000000000");
            }
        } catch (Exception e) {
            errors.put("giá sản phâm", "Giá sản phẩm phải là số");
        }
        int pQuantity = 0;
        try {
            pQuantity = Integer.parseInt(request.getParameter("quantity"));
            if (pQuantity>1000||pQuantity<0) errors.put("số lượng sản phẩm", "Số lượng sp tring khoảng từ 0-1000");
        } catch (Exception e) {
            errors.put("số lượng sản phẩm", "Số lượng sản phẩm phải là số");
        }
        String color = request.getParameter("color");
        String pDesc = request.getParameter("desc");
        int pCategory = 0;
        try {
            pCategory = Integer.parseInt(request.getParameter("category"));
        } catch (Exception e) {
            errors.put("danh mục sản phẩ", "Chưa đúng danh mục sản phẩm");
        }
        return new Product(pName, pPrice, pQuantity, color, pDesc,pCategory);
    }

    public void destroy() {
    }
}