package vn.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 5, max = 45, message = "Họ tên không được trống, số ký tự từ khoảng 5-45 ký tự!!!")
    private String firstName;

    @Size(min = 5, max = 45, message = "Họ tên không được trống, số ký tự từ khoảng 5-45 ký tự!!!")
    private String lastName;

    @Pattern(regexp = "(\\+84|0[3|5|7|8|9])+([0-9]{8})", message = "Số điện thoại không được trống, bắt đầu bằng +84 hoặc 0 và chiều dài 10 ký tự!!!")
    private String phoneNumber;

    @Pattern(regexp = "^(1[8-9]|[2-9]\\d|\\d{3,})$", message = "Tuổi không được trống, tuổi phải >= 18!!!")
    private String age;

    @Pattern(regexp = "^[\\w\\d\\-_.]{3,20}@[\\w]{3,7}+(.[\\w]{2,5}){1,5}$", message = "Email không được trống, số ký tự từ khoảng 5-45 ký tự!!!")
    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
