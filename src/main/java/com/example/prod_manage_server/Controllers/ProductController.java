package com.example.prod_manage_server.Controllers;

import com.example.prod_manage_server.dto.ProductDTO;
import com.example.prod_manage_server.entity.Category;
import com.example.prod_manage_server.entity.Product;
import com.example.prod_manage_server.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@Tag(name = "Produits", description = "API pour la gestion des produits")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @Operation(summary = "Ajouter un produit")
    @PostMapping
    public ResponseEntity<Product> AddProduct(@RequestBody ProductDTO product) {
        Product newProduct = productService.create(product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @Operation(summary = "Modifier un produit")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updateProduct = productService.update(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @Operation(summary = "Supprimer un produit")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Obtenir la liste des produits")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Operation(summary = "Rechercher multi-critères")
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return ResponseEntity.ok(productService.search(name, category, minPrice, maxPrice));
    }



}
