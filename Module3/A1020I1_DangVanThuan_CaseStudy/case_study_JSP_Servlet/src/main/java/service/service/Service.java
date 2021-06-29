package service.service;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    List<model.service.Service> findAll();

    model.service.Service findById(int id);

    void deleteService(int id);

    void updateService(int id, model.service.Service service);

    void insertService(model.service.Service service) throws SQLException;
}
