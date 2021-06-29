package vn.codegym.repository;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findbyID(int id);

    void save(Customer customer);

    void update (Customer customer);

    void remove (Customer customer);
}
