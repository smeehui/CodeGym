package com.smee.productmgmt.category;

import com.smee.productmgmt.product.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM category";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/module";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Smee@99123";
    private List<Category> products;
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
    public List<Category> getAll() {
        products = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = Category.parse(rs);
                products.add(category);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
