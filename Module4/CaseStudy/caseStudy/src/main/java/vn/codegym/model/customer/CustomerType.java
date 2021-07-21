package vn.codegym.model.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class CustomerType {

    @Id
    private int type_id;

    @NotNull
    private String type_name;

    @OneToMany(mappedBy = "customerType")
    Set<Customer> customers;

    public CustomerType() {
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "type_id=" + type_id +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
