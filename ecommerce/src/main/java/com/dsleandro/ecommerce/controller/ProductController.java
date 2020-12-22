package com.dsleandro.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import com.dsleandro.ecommerce.models.Product;
import com.dsleandro.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

        Product productData = productService.save(product);

        return ResponseEntity.ok(productData);
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllProducts() {

        List<Product> products = new ArrayList<Product>();

        products = productService.findAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> findByproductId(@PathVariable String productId) {

        Product product = new Product();

        product = productService.productId(productId);

        return ResponseEntity.ok(product);
    }

    @PutMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {

        Product productData = productService.save(product);

        return ResponseEntity.ok(productData);
    }

    @DeleteMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> deleteByProductId(@PathVariable String productId) {

        Product product = new Product();

        product = productService.deleteById(productId);

        return ResponseEntity.ok(product);
    }

}
