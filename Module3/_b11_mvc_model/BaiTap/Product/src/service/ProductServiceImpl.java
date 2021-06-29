package service;

import model.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByID(int id) {
        return productRepository.findByID(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productRepository.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> searchByKeyword(String keyword) {
        return productRepository.searchByKeyword(keyword);
    }
}
