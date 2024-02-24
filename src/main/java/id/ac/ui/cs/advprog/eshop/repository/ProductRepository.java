package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements ProductInterfaceRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        if(product.getProductId() == null){
            UUID uuid = UUID.randomUUID();
            product.setProductId(uuid.toString());
        }
        productData.add(product);
        return product;
    }

    public  Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        return productData.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    public Product update(String id, Product updatedProduct) {
        for (int i = 0; i < productData.size(); i++) {
            Product existingProduct = productData.get(i);
            if (existingProduct.getProductId().equals(updatedProduct.getProductId())) {
                // Update existing product
                existingProduct.setProductName(updatedProduct.getProductName());
                existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
                return existingProduct;
            }
        }
        return null;

    }

    public void delete(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                productData.remove(product);
                break; // Assuming productId is unique, so we can exit the loop once found
            }
        }
    }

}