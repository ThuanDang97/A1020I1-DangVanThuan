package service;

import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void deleteUser(int id) {
        this.userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(int id, User user) {
        this.userRepository.updateUser(id,user);
        return false;
    }

    @Override
    public void insertUser(User user) {

        this.userRepository.insertUser(user);
    }

    @Override
    public List<User> findCountry(String country) {
        return this.userRepository.findCountry(country);
    }

    @Override
    public List<User> findAllUser() {
        return this.userRepository.findAllUser();
    }

    @Override
    public User findUserById(int id) {
        return this.userRepository.findUserById(id);
    }

    @Override
    public boolean updateUsers(int id, User user) {
        this.userRepository.updateUsers(id, user);
        return false;
    }

    @Override
    public void deleteUsers(int id) {
        this.userRepository.deleteUsers(id);
    }

    @Override
    public void addUserTransaction(User user) {
        this.userRepository.addUserTransaction(user);
    }
}
