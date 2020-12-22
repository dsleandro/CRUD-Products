package com.dsleandro.ecommerce.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dsleandro.ecommerce.models.Product;

@Repository("productRepository")
public interface ProductRepository extends MongoRepository<Product, Serializable> {

    Product findById(String id);

    Product deleteById(String id);
}
