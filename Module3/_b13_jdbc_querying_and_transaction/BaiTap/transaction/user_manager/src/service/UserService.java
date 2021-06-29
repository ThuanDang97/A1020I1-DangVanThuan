package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById (int id);
    void deleteUser (int id);
    boolean updateUser (int id, User user);
    void insertUser (User user);
    List<User> findCountry(String country);
    //  Stored Procedures
    List<User> findAllUser();
    User findUserById(int id);

    boolean updateUsers(int id, User user);

    void deleteUsers(int id);

    void addUserTransaction(User user);
}
