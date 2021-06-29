package service.contract;

import model.contract.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    Contract findById(int id);

    void deleteContract(int id);

    void updateContract(int id, Contract contract);

    void insertContract(Contract contract) throws SQLException;
}
