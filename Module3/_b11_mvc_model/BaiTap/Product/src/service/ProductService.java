package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findByID(int id);

    List<Product> findByName(String name);

    void saveProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);

    List<Product> searchByKeyword(String keyword);
}
