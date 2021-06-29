package model.service;

import model.Product;
import model.repository.ProductRepository;
import model.repository.ProductRepositoryImpl;

import java.util.List;

public class ProducServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
