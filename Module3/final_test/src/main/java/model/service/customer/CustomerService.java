package model.service.customer;

import model.bean.customer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void deleteCustomer(int id);

    void updateCustomer(int id, Customer customer);

    void insertCustomer(Customer customer);

    List<Customer> findCustomer(String name);

}
