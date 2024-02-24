package id.ac.ui.cs.advprog.eshop.service;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductInterfaceRepository;

@Service
public class ProductCreateServiceImpl implements ProductCreateService{
    @Autowired
    private ProductInterfaceRepository productRepository;
    @Override
    public Product create(Product product){
        productRepository.create(product);
        return product;
    }
}
