package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById (int id);
    void deleteUser (int id);
    void updateUser (int id, User user);
    void insertUser (User user);
    List<User> findCountry(String country);
    //  Stored Procedures
    List<User> findAllUser();
    User findUserById(int id);

    void updateUsers(int id, User user);

    void deleteUsers(int id);

    String addUserTransaction(User user);
}
