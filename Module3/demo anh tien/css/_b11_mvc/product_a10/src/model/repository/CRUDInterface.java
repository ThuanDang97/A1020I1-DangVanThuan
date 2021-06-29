package model.repository;

import java.util.List;

public interface CRUDInterface<T> {
    List<T> findAll();
    T findById(int id);
    void deleteById(int id);
    void save(T product);
}
