package com.nimap.demo.respocitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.demo.model.Product;

public interface ProductRespocitory extends JpaRepository<Product, Long> {

}
