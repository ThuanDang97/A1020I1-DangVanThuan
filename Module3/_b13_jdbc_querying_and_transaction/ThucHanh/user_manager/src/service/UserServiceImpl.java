package service;

import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.sql.SQLException;
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
        this.userRepository.updateUser(id, user);
        return false;
    }

    @Override
    public void insertUser(User user) {

        this.userRepository.insertUser(user);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        this.userRepository.insertUser(user);
    }
}
