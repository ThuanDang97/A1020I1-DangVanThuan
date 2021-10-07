package vn.codegym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
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

public class Customer implements Validator {

    @Id
    @Column(name = "customer_id", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^KH-\\d{4}$",
            message = "Customer ID must be in KH-XXXX format. (i.e: KH-1234)")
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    @Column(name = "customer_name", columnDefinition = "VARCHAR(45) NOT NULL")
    @NotBlank(message = "Customer name must not be empty.")
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    private String customerBirthday;

    @Column(name = "customer_gender")
    private boolean customerGender;

    @Column(name = "customer_id_card", columnDefinition = "VARCHAR(45) NOT NULL")
    @Pattern(regexp = "^(\\d{9}|\\d{12})$",
            message = "ID card number must contain 9 or 12 digits. (i.e: 201871256)")
    private String customerIdCard;

    @Column(name = "customer_phone", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$",
            message = "Phone number must start with 090 or 091 or (84)+90 or (84)+91.\n(i.e: 0905456789 / (84)+905456789)")
    private String customerPhone;

    @Column(name = "customer_email", columnDefinition = "VARCHAR(45)")
    @Email(message = "Email must be in correct format. (i.e: abc@codegym.vn)")
    private String customerEmail;

    @Column(name = "customer_address", columnDefinition = "VARCHAR(45)")
    @NotBlank(message = "Customer address must not be empty.")
    private String customerAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Contract> contractSet;

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }


    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if (customer.customerBirthday.equals("")) {
            errors.rejectValue("customerBirthday", "customer.age.at.least.18");
        } else {
            String[] date = customer.customerBirthday.split("-");
            int year = Integer.parseInt(date[0]);
            String birthday = (year + 18) + "-" + date[1] + "-" + date[2];
            Date birthday18th;
            try {
                birthday18th = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                if (birthday18th.compareTo(new Date()) > 0) {
                    errors.rejectValue("customerBirthday", "customer.age.at.least.18");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
