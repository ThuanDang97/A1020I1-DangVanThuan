package vn.codegym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    private String username;

    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;


    @OneToOne(mappedBy = "appUser")
    @JsonIgnore
    private Employee employee;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<UserRole> userRoles;

    public AppUser(String username) {
        this.username = username;
        this.encryptedPassword = "123456";
    }

    public AppUser() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
