package repository.employee;

import model.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    Employee findById(int id);

    void deleteEmployee(int id);

    void updateEmployee(int id, Employee employee);

    void insertEmployee(Employee employee);
}
