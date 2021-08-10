package vn.codegym.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
