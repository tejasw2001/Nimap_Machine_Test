package com.nimap.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.demo.model.Product;
import com.nimap.demo.respocitory.ProductRespocitory;

@Service
public class ProductServices {
	 @Autowired
	    private ProductRespocitory productRepository;

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Product getProductById(Long id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Product updateProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
	    public List<Product> getAllProducts(int page, int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        Page<Product> productPage = productRepository.findAll(pageable);
	        return productPage.getContent();
	    }

	}