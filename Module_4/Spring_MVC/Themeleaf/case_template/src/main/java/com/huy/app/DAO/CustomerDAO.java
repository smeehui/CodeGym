package com.huy.app.DAO;

import com.huy.app.model.Customer;

import java.sql.*;

public class CustomerDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Smee@99123";
    private final String SP_ADD_NEW_CUSTOMER = "CALL addNewCustomer(?,?,?,?,?)";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void addNewCustomer(Customer customer) throws SQLException {
        try (Connection connection = getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(SP_ADD_NEW_CUSTOMER);
            callableStatement.setString(1, customer.getFullName());
            callableStatement.setString(2,customer.getEmail());
            callableStatement.setString(3,customer.getPhone());
            callableStatement.setString(4, customer.getAddress());
            callableStatement.registerOutParameter(5, Types.VARCHAR);
            callableStatement.executeUpdate();
            String name = callableStatement.getString(5);
        }
    }
}
