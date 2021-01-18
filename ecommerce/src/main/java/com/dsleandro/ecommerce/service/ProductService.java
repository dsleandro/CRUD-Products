package com.dsleandro.ecommerce.service;

import java.util.List;

import com.dsleandro.ecommerce.models.Product;

public interface ProductService {

	public abstract Product productId(String productId);

	public abstract Product save(Product entity);

	public abstract List<Product> findAll(String username);

	public abstract Product update(Product entity);

	public abstract Product deleteById(String productId);

}
