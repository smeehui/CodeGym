package huy.dao;

import huy.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();
    List<User> selectRemovedUsers();

    public boolean updateUserStatus(int id,boolean status) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    List<User> selectByCountry(String query);
    List<User> selectAllUserOrderByName();
    User getUserById(int id);

    void insertUserStoreP(User user) throws SQLException;
}
