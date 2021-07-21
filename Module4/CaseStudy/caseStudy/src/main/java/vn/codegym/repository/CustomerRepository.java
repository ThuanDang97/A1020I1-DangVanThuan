package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
