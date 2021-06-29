package repository.employee;

import model.employee.Employee;
import repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position.position_name as position, education_degree.education_degree_name as education_degree, division.division_name as division\n" +
                            "from employee\n" +
                            "left join position on position.position_id = employee.position_id\n" +
                            "left join education_degree on education_degree.education_degree_id = employee.education_degree_id\n" +
                            "left join division on division.division_id = employee.division_id;"
            );
            Employee employee = null;
            while (resultSet.next()) {
                employee = new Employee();

                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeBirthday(resultSet.getDate("employee_birthday"));
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                employee.setPositionName(resultSet.getString("position"));
                employee.setEducationDegreeName(resultSet.getString("education_degree"));
                employee.setDivisionName(resultSet.getString("division"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "select employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id\n" +
                            "from employee\n" +
                            "where employee_id = ?;"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee();
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeBirthday(resultSet.getDate("employee_birthday"));
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                employee.setPositionId(resultSet.getInt("position_id"));
                employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                employee.setDivisionId(resultSet.getInt("division_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "delete \n" +
                            "from employee \n" +
                            "where employee_id = ?;"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "update employee\n" +
                            "set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ?\n" +
                            "where employee_id = ?;"
            );
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setDate(2,employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setInt(11, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id)\n" +
                            "values(?,?,?,?,?,?,?,?,?,?);"
            );
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setDate(2,employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
