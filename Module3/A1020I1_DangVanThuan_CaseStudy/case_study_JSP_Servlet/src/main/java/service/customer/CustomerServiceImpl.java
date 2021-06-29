package service.customer;

import model.customer.Customer;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryImpl;

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
}
