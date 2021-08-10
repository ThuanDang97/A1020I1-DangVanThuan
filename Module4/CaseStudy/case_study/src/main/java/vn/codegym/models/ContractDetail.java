package vn.codegym.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contract_detail",
        uniqueConstraints = {@UniqueConstraint(name = "CONTRACT_SERVICE_UK", columnNames = {"contract_id", "attach_service_id"})})
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private int contractDetailId;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", nullable = false)
    private AttachService attachService;

    @Column(name = "quantity")
    private int quantity;

    public ContractDetail(Contract contract) {
        this.contract = contract;
    }

    public ContractDetail() {
    }

    public ContractDetail(int contractDetailId, AttachService attachService, int quantity) {
        this.contractDetailId = contractDetailId;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractDetail detail = (ContractDetail) o;
        return Objects.equals(contract, detail.contract) &&
                Objects.equals(attachService, detail.attachService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contract, attachService);
    }
}
