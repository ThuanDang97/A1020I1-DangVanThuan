package vn.codegym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Integer rentTypeId;

    @Column(name = "rent_type_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String rentTypeName;

    @Column(name = "rent_type_cost", nullable = false)
    private double rentTypeCost;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<ResortService> resortServiceSet;

    public RentType() {
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<ResortService> getResortServiceSet() {
        return resortServiceSet;
    }

    public void setResortServiceSet(Set<ResortService> resortServiceSet) {
        this.resortServiceSet = resortServiceSet;
    }
}
