package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProducts = new ArrayList<>();
        productIterator.forEachRemaining(allProducts::add);
        return allProducts;
    }

    @Override
    public Product update(String id, Product updatedProduct) {
        productRepository.update(id, updatedProduct);
        return updatedProduct;
    }

    @Override
    public Product findById(String productId) {
        Product product = productRepository.findById(productId);
        if (product != null) {
            return product;
        } else {
            return null;
        }
    }

    @Override
    public void delete(String productId) {
        productRepository.delete(productId);
    }
}
