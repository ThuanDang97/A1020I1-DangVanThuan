package vn.codegym.services.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import vn.codegym.models.Customer;
import vn.codegym.repository.customer.CustomerRepository;
import vn.codegym.services.customer.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByKey(String key, Pageable pageable) {
        return repository.findAllByKey(key, pageable);
    }

    @Override
    public void validateExistingId(Customer customer, Errors errors) {
        Customer cus = findById(customer.getCustomerId());
        if (cus != null) {
            errors.rejectValue("customerId", "duplicate.customer.id");
        }
    }
}
