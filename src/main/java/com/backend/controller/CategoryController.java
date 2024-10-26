package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.CategoryConstant;
import com.backend.entity.CategoryEntity;
import com.backend.entity.ProductConstant;
import com.backend.entity.ProductEntity;
import com.backend.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public List<CategoryEntity> getAllCategoryEntities(
			@RequestParam(value = "page", defaultValue = CategoryConstant.page_Number) int pageNo,
	        @RequestParam(value = "size", defaultValue = CategoryConstant.page_Size) int pageSize) {
		return (List<CategoryEntity>) categoryService.getAllCategoryEntities(pageNo, pageSize);
	}
	
	@GetMapping("/{id}")
	Optional<CategoryEntity> getCategoryEntityById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
//	@PostMapping
//	CategoryEntity createCategoryEntity(@RequestBody CategoryEntity categoryEntity) {
//		return categoryService.createCategory(categoryEntity);
//	}	
	
	@PostMapping
	List<CategoryEntity> createCategoryEntity(@RequestBody List<CategoryEntity> categoryEntity) {
		return categoryService.createCategoryEntities(categoryEntity);
	}
	
	@PutMapping("/{id}")
	CategoryEntity updateCategoryEntity(@PathVariable Long id, @RequestBody CategoryEntity categoryEntity) {
		return categoryService.updateCategory(id, categoryEntity);
	}
	
	@DeleteMapping("/{id}")
	void deletCategoryEntity(@PathVariable Long id) {
		categoryService.deleteCategoryById(id);
	}
}
