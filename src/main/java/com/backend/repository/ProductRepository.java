package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
}
