package com.backend.service;

import com.backend.entity.ProductEntity;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
	//Page<ProductEntity> getProducts(int pageNum, int pageSize);
	
	List<ProductEntity> productEntities(int pageNo, int pageSize);
	
	//Pageable getPagable(int pageNo, int pageSize);
	
	List<ProductEntity> productEntities();
	
    Optional<ProductEntity> getProductById(Long id);
    
    ProductEntity createProduct(ProductEntity productEntity);
    
    //List<ProductEntity> createProductEntities(List<ProductEntity> productEntities);
    
    ProductEntity updateProduct(Long id, ProductEntity updatedProductEntity);
    
    void deleteProduct(Long id);
}
