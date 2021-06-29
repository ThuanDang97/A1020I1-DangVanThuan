package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void edit (int id, Product product);

    void delete(int id);
}
