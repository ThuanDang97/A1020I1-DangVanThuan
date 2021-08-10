package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.Division;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
}
