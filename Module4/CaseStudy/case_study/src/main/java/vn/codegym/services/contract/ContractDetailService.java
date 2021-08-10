package vn.codegym.services.contract;

import vn.codegym.models.ContractDetail;

public interface ContractDetailService {

    ContractDetail findById(Integer id);

    void save(ContractDetail contractDetail);

    void delete(Integer id);

}
