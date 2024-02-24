package id.ac.ui.cs.advprog.eshop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductInterfaceRepository;

@Service
public class ProductUpdateServiceImpl implements ProductUpdateService {
    @Autowired
    private ProductInterfaceRepository productRepository;
    @Override
    public void update(String productId, Product product){
        productRepository.update(productId, product);
    }
}
