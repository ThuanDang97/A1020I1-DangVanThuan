package vn.codegym.services.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.models.Contract;

public interface ContractService {

    Page<Contract> findAll(Pageable pageable);

    Contract findById(Integer id);

    void save(Contract contract);

    void delete(Integer id);

    double getTotalAmount(Contract contract);

}
