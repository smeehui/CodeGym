package com.smee.productmgmt.product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM products";
    private static final String INSERT_PRODUCT = "INSERT INTO products (name,price,quantity,color,description,category) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM products WHERE id =?";
    private static final String UPDATE_PRODUCT = "UPDATE products SET name = ?,price=?,quantity=?,color=?,description=?,category=? WHERE id =?";
    private static final String SEARCH_BY_NAME = "SELECT * FROM products WHERE name LIKE ?";
    private static final String DELETE_BY_ID = "DELETE FROM products WHERE id = ?";

    private final String jdbcURL = "jdbc:mysql://localhost:3306/module";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Smee@99123";
    private List<Product> products;
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Product> getAll() {
        products = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = Product.parse(rs);
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Product getById(int id) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Product.parse(rs);
            }
            return null;
        }
    }

    public boolean addNew(Product product) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDesc());
            preparedStatement.setInt(6, product.getCategory());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public boolean update(Product product) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDesc());
            preparedStatement.setInt(6, product.getCategory());
            preparedStatement.setInt(7, product.getId());
            return preparedStatement.executeUpdate()>0;
        }
    }

    public Product getByName(String query) {
        return null;
    }

    public List<Product> searchByName(String q) {
        products = new ArrayList<>();
        String query = "%"+q +"%";
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1,query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(Product.parse(rs));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

