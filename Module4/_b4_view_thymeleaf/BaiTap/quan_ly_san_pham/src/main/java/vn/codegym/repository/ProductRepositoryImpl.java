package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone 1", 100));
        products.add(new Product(2, "Iphone 2", 200));
        products.add(new Product(3, "Iphone 3", 300));
        products.add(new Product(4, "Iphone 4", 400));
        products.add(new Product(5, "Iphone 5", 500));
        products.add(new Product(6, "Iphone 6", 600));
        products.add(new Product(7, "Iphone 7", 700));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void edit(int id, Product product) {

    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
