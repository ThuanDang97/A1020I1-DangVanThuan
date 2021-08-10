package vn.codegym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Contract implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "contract_start_date", columnDefinition = "DATE NOT NULL")
    private String contractStartDate;

    @Column(name = "contract_end_date", columnDefinition = "DATE")
    private String contractEndDate;

    @Column(name = "contract_deposit")
    @Min(value = 0, message = "Deposit must be a positive number.")
    private double contractDeposit;

    @Column(name = "contract_total_money")
    private double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @NotNull(message = "Resort service field must not be empty.")
    private ResortService resortService;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @NotNull(message = "Employee field must not be empty.")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull(message = "Customer field must not be empty.")
    private Customer customer;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<ContractDetail> contractDetails;

    public Contract() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public ResortService getResortService() {
        return resortService;
    }

    public void setResortService(ResortService resortService) {
        this.resortService = resortService;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        if (contract.contractStartDate.equals("")) {
            errors.rejectValue("contractStartDate", "start.date.null");
        } else if (contract.contractEndDate.equals("")) {
            errors.rejectValue("contractEndDate", "end.date.null");
        } else {
            try {
                Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.contractStartDate);
                Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.contractEndDate);
                if (startDate.compareTo(endDate) > 0) {
                    errors.rejectValue("contractStartDate", "start.date.after");
                    errors.rejectValue("contractEndDate", "end.date.before");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
