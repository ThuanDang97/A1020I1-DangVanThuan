package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById (int id);
    void deleteUser (int id);
    void updateUser (int id, User user);
    void insertUser (User user);
    public User getUserById(int id);
    public void insertUserStore(User user) throws SQLException;

}
