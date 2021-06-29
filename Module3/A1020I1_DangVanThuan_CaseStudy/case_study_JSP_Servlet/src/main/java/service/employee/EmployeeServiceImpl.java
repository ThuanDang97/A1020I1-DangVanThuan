package service.employee;

import model.employee.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        this.employeeRepository.updateEmployee(id, employee);
    }

    @Override
    public void insertEmployee(Employee employee) {
        this.employeeRepository.insertEmployee(employee);
    }
}
