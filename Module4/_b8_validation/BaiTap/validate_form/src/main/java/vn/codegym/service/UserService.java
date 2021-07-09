package vn.codegym.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.User;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    void save(User user);

    void update(User user);

    void delete(User user);

    User findById(int id);
}
