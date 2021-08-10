package vn.codegym.services.contract.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.models.Contract;
import vn.codegym.models.ContractDetail;
import vn.codegym.repository.contract.ContractDetailRepository;
import vn.codegym.services.contract.ContractDetailService;
import vn.codegym.services.contract.ContractService;

import java.util.Set;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    @Autowired
    private ContractDetailRepository repository;
    @Autowired
    private ContractService contractService;

    @Override
    public ContractDetail findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        Contract contract = contractService.findById(contractDetail.getContract().getContractId());
        Set<ContractDetail> contractDetailSet = contract.getContractDetails();
        for (ContractDetail detail : contractDetailSet) {
            if (detail.equals(contractDetail)) {
                contractDetail.setQuantity(detail.getQuantity() + contractDetail.getQuantity());
                contractDetail.setContractDetailId(detail.getContractDetailId());
                break;
            }
        }
        repository.save(contractDetail);
        contractService.save(contract);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
