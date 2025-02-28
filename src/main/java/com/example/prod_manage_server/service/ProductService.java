package com.example.prod_manage_server.service;

import com.example.prod_manage_server.dto.ProductDTO;
import com.example.prod_manage_server.entity.Category;
import com.example.prod_manage_server.entity.Product;
import com.example.prod_manage_server.mapper.ProductMapper;
import com.example.prod_manage_server.repository.CategoryRepository;
import com.example.prod_manage_server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }


    public Product create(ProductDTO productDTO){
        Optional<Category> category = categoryRepository.findById(productDTO.getCategory());
        Product product = productMapper.toProduct(productDTO);
        product.setCategory(category.get());
        return productRepository.save(productMapper.toProduct(productDTO));
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

    public List<Product> search(String name, String category, Double minPrice, Double maxPrice) {
        return productRepository.findByFilters(name, category, minPrice, maxPrice);
    }
}
