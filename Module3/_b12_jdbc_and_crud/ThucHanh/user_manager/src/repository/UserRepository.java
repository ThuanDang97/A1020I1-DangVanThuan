package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById (int id);
    boolean deleteUser (int id);
    void updateUser (int id, User user);
    void insertUser (User user);
}
