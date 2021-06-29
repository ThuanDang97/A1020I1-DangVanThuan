package repository;

import model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();

        productMap.put(1, new Product(1, "Iphone 6", 500, "Old", "Apple"));
        productMap.put(2, new Product(2, "Iphone 7", 600, "Old", "Apple"));
        productMap.put(3, new Product(3, "Iphone 8", 700, "Old", "Apple"));
        productMap.put(4, new Product(4, "Iphone X", 900, "Like New", "Apple"));
        productMap.put(5, new Product(5, "Iphone 11", 1200, "Like New", "Apple"));
        productMap.put(6, new Product(6, "Iphone 12", 1500, "New", "Apple"));
        productMap.put(7, new Product(7, "Iphone 5", 450, "Old", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findByID(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        Set<Integer> keySet = productMap.keySet();
        for (int key : keySet) {
            if (productMap.get(key).getNameProduct().toLowerCase().contains(name.toLowerCase())) {
                list.add(productMap.get(key));
            }
        }
        return list;
    }

    @Override
    public void saveProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> searchByKeyword(String keyword) {
        return productMap.values()
                .stream()
                .filter(cus -> cus.getNameProduct().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }
}
