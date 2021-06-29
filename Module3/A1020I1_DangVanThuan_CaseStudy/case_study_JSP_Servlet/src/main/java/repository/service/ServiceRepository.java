package repository.service;

import model.service.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceRepository {
    List<Service> findAll();

    Service findById(int id);

    void deleteService(int id);

    void updateService(int id, Service service);

    void insertService(Service service) throws SQLException;
}
