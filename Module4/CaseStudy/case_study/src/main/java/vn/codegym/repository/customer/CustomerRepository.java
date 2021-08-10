package vn.codegym.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Page<Customer> findAll(Pageable pageable);

    @Query("SELECT c FROM Customer c WHERE " +
            "c.customerId LIKE %:key% OR " +
            "c.customerName LIKE %:key% OR " +
            "c.customerType.customerTypeName LIKE %:key% OR " +
            "c.customerAddress LIKE %:key%")
    Page<Customer> findAllByKey(String key, Pageable pageable);

}
