package com.nimap.demo.respocitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.demo.model.Category;

public interface CatagoryRespocitory extends JpaRepository<Category, Long> {

}
