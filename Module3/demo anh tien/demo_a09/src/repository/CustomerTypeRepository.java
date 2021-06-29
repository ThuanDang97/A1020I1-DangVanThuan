package repository;



import model.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    CustomerType findByID(int id);
    List<CustomerType> selectAllCustomerType();
}
