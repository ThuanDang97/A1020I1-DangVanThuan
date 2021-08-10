package vn.codegym.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "service")

public class ResortService {

    @Id
    @Column(name = "service_id", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^DV-\\d{4}$",
            message = "Service ID must be in DV-XXXX format. (i.e: DV-1234)")
    private String serviceId;

    @Column(name = "service_name", columnDefinition = "VARCHAR(45) NOT NULL")
    @NotBlank(message = "Service name must not be empty.")
    private String serviceName;

    @Column(name = "service_area", columnDefinition = "INT NOT NULL")
    @Pattern(regexp = "^[1-9]\\d*$",
            message = "Area must be a positive number.")
    private String serviceArea;

    @Column(name = "service_cost", columnDefinition = "DOUBLE NOT NULL")
    @Pattern(regexp = "^[1-9]\\d*(\\.\\d+)?$",
            message = "Service cost must be a positive number.")
    private String serviceCost;

    @Column(name = "service_max_people", columnDefinition = "INT NOT NULL")
    @Pattern(regexp = "^[1-9]\\d*$",
            message = "Number of people must be a positive number.")
    private String serviceMaxPeople;

    @Column(name = "room_standard", columnDefinition = "VARCHAR(45)")
    private String roomStandard;

    @Column(name = "description_other_convenience", columnDefinition = "VARCHAR(45)")
    private String descriptionOtherConvenience;

    @Column(name = "pool_area")
    @Min(value = 0, message = "Area must be a positive number.")
    private int poolArea;

    @Column(name = "number_of_floors")
    @Min(value = 0, message = "Number of floors must be a positive number.")
    private int numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "resortService", cascade = CascadeType.REMOVE)
    private Set<Contract> contractSet;

    public ResortService() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
