package com.example.prod_manage_server.service;

import com.example.prod_manage_server.entity.Category;
import com.example.prod_manage_server.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category){
        return categoryRepository.save(category);
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        if(categoryRepository.findById(id).isEmpty()){
            return null;
        }
        return categoryRepository.findById(id).get();
    }

    public Category update(Category category){
        return categoryRepository.save(category);
    }
    public void  delete(Long id){
        categoryRepository.deleteById(id);
    }
}
