package com.dsleandro.ecommerce.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.dsleandro.ecommerce.models.Product;
import com.dsleandro.ecommerce.repository.ProductRepository;
import com.dsleandro.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product productId(String productId) {

		Product product = null;

		try {
			product = productRepository.findById(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product save(Product entity) {

		String loggedUser = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		entity.setUser(loggedUser);

		Product product = null;

		try {
			product = productRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public List<Product> findAll(String username) {

		List<Product> productList = new ArrayList<Product>();

		try {
			productList = productRepository.findByUser(username);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public Product update(Product entity) {

		Product product = null;

		try {

			product = productRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product deleteById(String productId) {

		Product product = null;

		try {

			product = productRepository.deleteById(productId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return product;
	}

}
