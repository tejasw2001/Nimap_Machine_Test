package com.nimap.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.demo.model.Category;
import com.nimap.demo.service.CatagoryServices;

@RestController
@RequestMapping("/api/categories")
public class CatagoryCon {
	 @Autowired
	    private CatagoryServices categoryService;

	    @GetMapping
	    public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,
	                                           @RequestParam(defaultValue = "10") int size) {
	        return categoryService.getAllCategories(page, size);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        Category existingCategory = categoryService.getCategoryById(id);
	        if (existingCategory != null) {
	            category.setId(id);
	            return ResponseEntity.ok(categoryService.updateCategory(category));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
	        Category category = categoryService.getCategoryById(id);
	        if (category != null) {
	            return ResponseEntity.ok(category);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    @PostMapping
	    public Category createCategory(@RequestBody Category category) {
	        return categoryService.createCategory(category);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
	        Category existingCategory = categoryService.getCategoryById(id);
	        if (existingCategory != null) {
	            categoryService.deleteCategory(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}

