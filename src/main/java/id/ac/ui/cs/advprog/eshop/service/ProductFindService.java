package id.ac.ui.cs.advprog.eshop.service;
import java.util.List;
import id.ac.ui.cs.advprog.eshop.model.Product;

public interface ProductFindService {
    public List<Product> findAll();
    Product findById(String productId);
}
