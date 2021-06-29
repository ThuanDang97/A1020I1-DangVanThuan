package model.service.customer;

import model.bean.customer.Customer;
import model.repository.customer.CustomerRepository;
import model.repository.customer.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void deleteCustomer(int id) {
        this.customerRepository.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        this.customerRepository.updateCustomer(id,customer);
    }

    @Override
    public void insertCustomer(Customer customer) {
        try {
            this.customerRepository.insertCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findCustomer(String name) {
        return this.customerRepository.findCustomer(name);
    }
}
