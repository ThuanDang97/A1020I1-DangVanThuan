package vn.codegym.repository.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.models.AppUser;
import vn.codegym.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findAll(Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE " +
            "e.employeeName LIKE %:key% OR " +
            "e.employeeAddress LIKE %:key% OR " +
            "e.position.positionName LIKE %:key% OR " +
            "e.educationDegree.degreeName LIKE %:key% OR " +
            "e.division.divisionName LIKE %:key%")
    Page<Employee> findAllByKey(String key, Pageable pageable);

    Employee findByAppUser(AppUser appUser);

}
