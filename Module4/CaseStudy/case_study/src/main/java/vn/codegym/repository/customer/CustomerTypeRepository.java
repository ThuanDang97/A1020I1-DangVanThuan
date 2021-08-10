package vn.codegym.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
