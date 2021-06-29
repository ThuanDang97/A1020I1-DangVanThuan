package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById (int id);
    void deleteUser (int id);
    boolean updateUser (int id, User user);
    void insertUser (User user);
    public User getUserById(int id);
    public void insertUserStore(User user) throws SQLException;

}
