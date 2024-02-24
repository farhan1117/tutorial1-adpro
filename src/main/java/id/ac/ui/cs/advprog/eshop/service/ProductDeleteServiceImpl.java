package id.ac.ui.cs.advprog.eshop.service;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.repository.ProductInterfaceRepository;

@Service
public class ProductDeleteServiceImpl implements ProductDeleteService{
    @Autowired
    private ProductInterfaceRepository productRepository;
    @Override
    public void deleteProductById(String productId){
        productRepository.delete(productId);
    }
}
