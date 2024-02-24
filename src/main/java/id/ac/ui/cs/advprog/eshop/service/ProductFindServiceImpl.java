package id.ac.ui.cs.advprog.eshop.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductInterfaceRepository;

import javax.imageio.ImageTranscoder;

@Service
public class ProductFindServiceImpl implements ProductFindService {
    @Autowired
    private ProductInterfaceRepository productRepository;
    @Override
    public List<Product> findAll(){
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public Product findById(String productId){
        return productRepository.findById(productId);
    }
}
