package vn.codegym.model.customer;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class Customer implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customer_type", referencedColumnName = "type_id")
    private CustomerType customerType;

    @Size(min = 5, max = 50, message = "Họ tên không được để trống, ít nhất 5 ký tự!!!")
    private String name;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @PastOrPresent
    private Date birthDay;

    private boolean gender;

    @Size(min = 9, max = 12, message = "Id Card phải là số, tối đa 9 - 12 ký tự!!!")
    private int idCard;

    @Pattern(regexp = "(\\+84|0[3|5|7|8|9])+([0-9]{8})", message = "Số điện thoại không được trống, bắt đầu bằng +84 hoặc 0 và chiều dài 10 ký tự!!!")
    private String phoneNumber;

    @Email(message = "Email sai định dạng!!!")
    private String email;

    @NotNull(message = "Địa chỉ không được để trống!!!")
    private String address;

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerType=" + customerType +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", gender=" + gender +
                ", idCard=" + idCard +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
