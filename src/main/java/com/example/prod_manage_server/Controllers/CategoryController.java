package com.example.prod_manage_server.Controllers;

import com.example.prod_manage_server.dto.CategoryDTO;
import com.example.prod_manage_server.entity.Category;
import com.example.prod_manage_server.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Categorie", description = "API pour la recuperation des categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Liste de categories")
    @GetMapping
    public ResponseEntity<List<Category>> GetCategory() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
