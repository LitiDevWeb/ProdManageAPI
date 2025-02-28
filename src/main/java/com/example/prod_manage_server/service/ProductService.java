package com.example.prod_manage_server.service;

import com.example.prod_manage_server.entity.Product;
import com.example.prod_manage_server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product){
        return productRepository.save(product);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        if(productRepository.findById(id).isEmpty()){
            return null;
        }
        return productRepository.findById(id).get();
    }

    public Product update(Product product){
        return productRepository.save(product);
    }
    public void  delete(Long id){
        productRepository.deleteById(id);
    }
}
