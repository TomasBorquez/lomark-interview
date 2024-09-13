package me.tomas.borquez.section3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        // Adding some initial products
        products.add(new Product("Product 1", 19.99, "Description for Product 1"));
        products.add(new Product("Product 2", 29.99, "Description for Product 2"));
        products.add(new Product("Product 3", 39.99, "Description for Product 3"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
