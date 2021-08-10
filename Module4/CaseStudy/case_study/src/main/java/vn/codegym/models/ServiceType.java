package vn.codegym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")

public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;

    @Column(name = "service_type_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<ResortService> resortServiceSet;

    public ServiceType() {
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<ResortService> getResortServiceSet() {
        return resortServiceSet;
    }

    public void setResortServiceSet(Set<ResortService> resortServiceSet) {
        this.resortServiceSet = resortServiceSet;
    }
}
