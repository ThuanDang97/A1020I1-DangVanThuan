package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.customer.Customer;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void delete(Customer customer);

    void update(Customer customer);

    Customer findById(int id);
}
