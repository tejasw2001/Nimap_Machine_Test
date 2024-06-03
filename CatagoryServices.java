package com.nimap.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.demo.model.Category;
import com.nimap.demo.respocitory.CatagoryRespocitory;

@Service
public class CatagoryServices {
	 @Autowired
	    private CatagoryRespocitory categoryRepository;

	    public List<Category> getAllCategories() {
	        return categoryRepository.findAll();
	    }

	    public Category getCategoryById(Long id) {
	        return categoryRepository.findById(id).orElse(null);
	    }

	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public Category updateCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public void deleteCategory(Long id) {
	        categoryRepository.deleteById(id);
	    }
	    public List<Category> getAllCategories(int page, int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        Page<Category> categoryPage = categoryRepository.findAll(pageable);
	        return categoryPage.getContent();
	    }
	}