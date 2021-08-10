package vn.codegym.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.RentType;

public interface RentTypeRepository extends JpaRepository<RentType, Integer> {
}
