package model.repository.customer;

import model.bean.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void deleteCustomer(int id);

    void updateCustomer(int id, Customer customer);

    void insertCustomer(Customer customer) throws SQLException;

    List<Customer> findCustomer(String name);
}
