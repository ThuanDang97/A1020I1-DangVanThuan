package vn.codegym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name", columnDefinition = "VARCHAR(45) NOT NULL")
    @NotBlank(message = "Employee name must not be empty.")
    private String employeeName;

    @Column(name = "employee_birthday", columnDefinition = "DATE")
    private String employeeBirthday;

    @Column(name = "employee_id_card", columnDefinition = "VARCHAR(45) NOT NULL UNIQUE")
    @Pattern(regexp = "^(\\d{9}|\\d{12})$",
            message = "ID card number must contain 9 or 12 digits. (i.e: 201871256)")
    private String employeeIdCard;

    @Column(name = "employee_salary", columnDefinition = "DOUBLE")
    @Pattern(regexp = "^[1-9]\\d*(\\.\\d+)?$",
            message = "Salary must be a positive number.")
    private String employeeSalary;

    @Column(name = "employee_phone", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$",
            message = "Phone number must start with 090 or 091 or (84)+90 or (84)+91.\n(i.e: 0905456789 / (84)+905456789)")
    private String employeePhone;

    @Column(name = "employee_email", columnDefinition = "VARCHAR(45)")
    @Email(message = "Email must be in correct format. (i.e: abc@codegym.vn)")
    private String employeeEmail;

    @Column(name = "employee_address", columnDefinition = "VARCHAR(45)")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToOne
    @JoinColumn(name = "username")
    private AppUser appUser;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Contract> contractSet;

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if (employee.employeeBirthday.equals("")) {
            errors.rejectValue("employeeBirthday", "employee.age.at.least.18");
        } else {
            String[] date = employee.employeeBirthday.split("-");
            int year = Integer.parseInt(date[0]);
            String birthday = (year + 18) + "-" + date[1] + "-" + date[2];
            Date birthday18th;
            try {
                birthday18th = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                if (birthday18th.compareTo(new Date()) > 0) {
                    errors.rejectValue("employeeBirthday", "employee.age.at.least.18");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}