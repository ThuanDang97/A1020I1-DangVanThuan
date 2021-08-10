package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.EducationDegree;

public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
