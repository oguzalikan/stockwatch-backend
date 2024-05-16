package com.tobeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
