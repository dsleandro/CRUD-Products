package com.dsleandro.ecommerce.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dsleandro.ecommerce.models.Product;

@Repository("productRepository")
public interface ProductRepository extends MongoRepository<Product, Serializable> {

    Product findById(String id);

    List<Product> findByUser(String username);

    Product deleteById(String id);
}
