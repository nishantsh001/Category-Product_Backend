package com.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productname;
	private Double productPrice;
	
//	private CategoryEntity categoryEntity;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

//	public CategoryEntity getCategoryEntity() {
//		return categoryEntity;
//	}
//
//	public void setCategoryEntity(CategoryEntity categoryEntity) {
//		this.categoryEntity = categoryEntity;
//	}
	
	

}
