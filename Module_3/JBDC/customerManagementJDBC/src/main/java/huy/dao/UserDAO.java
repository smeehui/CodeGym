package huy.dao;

import huy.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Smee@99123";
    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country,status) VALUES (?, ?, ?,?);";
    private static final String SELECT_USER_BY_ID = "select * from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users where status=true";
    private static final String SELECT_REMOVED_USERS = "select * from users where status=false";
    private static final String DELETE_USERS_SQL = "update users set status = ? where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =?where id = ?;";
    private static final String SELECT_BY_COUNTRY = "select * from users where country like ? ";
    private static final String SELECT_ALL_USERS_SORT_BY_NAME = "select * from users order by name ASC";
    private static final String INSERT_USER_PERMISSION = "INSERT INTO userPermission values(?,?)";

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

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setBoolean(4, user.isStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (
                Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)
        ) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                boolean status = rs.getBoolean("status");
                user = new User(id, name, email, country);
                user.setStatus(status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                boolean status = rs.getBoolean("status");
                users.add(new User(id, name, email, country, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public List<User> selectRemovedUsers() {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REMOVED_USERS)
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                boolean status = rs.getBoolean("status");
                users.add(new User(id, name, email, country, status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public boolean updateUserStatus(int id, boolean status) throws SQLException {
        boolean rowDeleted;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)
        ) {
            statement.setBoolean(1, status);
            statement.setInt(2, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<User> selectByCountry(String query) {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_COUNTRY)
        ) {
            preparedStatement.setString(1, "%" + query + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                boolean status = rs.getBoolean("status");
                if (status) {
                    users.add(new User(id, name, email, country, status));
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> selectAllUserOrderByName() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_SORT_BY_NAME)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                boolean status = rs.getBoolean("status");
                if (status) {
                    users.add(new User(id, name, email, country, status));
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "{CALL getUserById(?)}";
        try (
                Connection connection = getConnection();
                CallableStatement callableStatement = connection.prepareCall(query)
        ) {
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                boolean status = rs.getBoolean("status");
                user = new User(id, name, email, country, status);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertUserStoreP(User user) {
        String query = "{CALL insertUser(?,?,?,?,?)}";
        try (
                Connection connection = getConnection();
                CallableStatement callableStatement = connection.prepareCall(query)
        ) {
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getCountry());
            callableStatement.setString(4, user.getEmail());
            callableStatement.setBoolean(5, user.isStatus());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permissions) {
        Connection conn=null;
        PreparedStatement psNewUser =null;
        PreparedStatement psPermission = null;
        ResultSet rs =null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            psNewUser = conn.prepareStatement(INSERT_USERS_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            psNewUser.setString(1, user.getName());
            psNewUser.setString(2, user.getEmail());
            psNewUser.setString(3, user.getCountry());
            psNewUser.setBoolean(4, user.isStatus());
            int rowAffected = psNewUser.executeUpdate();
            rs = psNewUser.getGeneratedKeys();
            int userID = 0;
            if (rs.next()) userID = rs.getInt(1);
            if (rowAffected == 1) {
                psPermission = conn.prepareStatement(INSERT_USER_PERMISSION);
                for (int perID : permissions) {
                    psPermission.setInt(1, userID);
                    psPermission.setInt(2, perID);
                    psPermission.executeUpdate();
                }
                conn.commit();
            } else conn.rollback();

        } catch (SQLException exSQL) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(exSQL.getMessage());
        }finally {
            try {
                if (rs != null) rs.close();

                if (psNewUser != null) psNewUser.close();

                if (psPermission != null) psPermission.close();

                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
