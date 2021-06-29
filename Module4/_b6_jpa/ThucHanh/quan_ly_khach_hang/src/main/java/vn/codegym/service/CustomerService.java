package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> findAll();

    Customer findbyID(int id);

    void save(Customer customer);

    void update (Customer customer);

    void remove (Customer customer);
}
