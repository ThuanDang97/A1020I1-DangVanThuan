package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void edit(int id, Product product);

    void delete(int id);
}
