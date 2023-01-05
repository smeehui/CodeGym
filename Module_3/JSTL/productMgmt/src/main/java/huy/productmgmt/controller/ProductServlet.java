package huy.productmgmt.controller;

import huy.productmgmt.model.Product;
import huy.productmgmt.service.IProdService;
import huy.productmgmt.service.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    static IProdService prodService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        switch (action) {
            case "view" -> showProdDetails(request, response);
            case "add" -> showAddNewProduct(request, response);
            case "edit" -> showEditProduct(request, response);
            case "update" -> updateStatus(request,response);
            case "removed" -> showRemovedProducts(request, response);
            case "available" -> showAvailableProducts(request,response);
            case "search" -> showSearchAction(request, response);
        }
    }

    private void showSearchAction(HttpServletRequest request, HttpServletResponse response) {
        String queryStr = request.getParameter("q");
        request.setAttribute("products",prodService.getByName(queryStr.toLowerCase()));
        request.setAttribute("view","all");
        request.setAttribute("q",queryStr);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showRemovedProducts(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/removed.jsp");
        request.setAttribute("products",prodService.getAll());
        request.setAttribute("view", "removed");
        try {
            dispatcher.forward(request,response);
            response.sendRedirect("products/removed.jsp");
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateStatus(HttpServletRequest request, HttpServletResponse response) {
        prodService.updateStatus(Integer.parseInt(request.getParameter("id")));
        try {
            switch (request.getParameter("type")) {
                case "remove" -> response.sendRedirect("/");
                case "restore" -> {
                    request.setAttribute("products",prodService.getAll());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("products/removed.jsp");
                    dispatcher.forward(request,response);
                }
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = prodService.getById(id);
        RequestDispatcher dispatcher;
        if (product==null)  dispatcher = request.getRequestDispatcher("notFound_404.jsp");
        else dispatcher = request.getRequestDispatcher("products/edit.jsp");
        try {
            request.setAttribute("product",product);
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAvailableProducts(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products",prodService.getAll());
        request.setAttribute("view","available");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAddNewProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showProdDetails(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = prodService.getById(id);
        RequestDispatcher dispatcher;
        if (product == null) dispatcher = request.getRequestDispatcher("nofound_404.jsp");
        else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("products/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add" -> addNewProduct(request, response);
            case "edit"-> editProduct(request, response);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String desc = request.getParameter("desc");
        boolean available = Boolean.parseBoolean(request.getParameter("available"));
        Product product = new Product(id, name, price, quantity, desc,available);
        prodService.update(id,product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = (int) (Math.random() * 1000);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String desc = request.getParameter("desc");
        boolean available = Boolean.parseBoolean(request.getParameter("available"));
        Product product = new Product(id, name, price, quantity, desc, available);
        prodService.addNew(product);
        response.sendRedirect("/");
    }
}
