package com.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.backend.entity.CategoryEntity;
import com.backend.exception.CategoryNotFoundException;
import com.backend.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryEntity> getAllCategoryEntities(int Page_No, int Page_Size) {
		Page<CategoryEntity> page = categoryRepository.findAll(PageRequest.of(Page_No, Page_Size));
		return page.getContent();
	}
	
	@Override
	public Optional<CategoryEntity> getCategoryById(Long id) {
		return categoryRepository.findById(id);
	}

//	@Override
//	public CategoryEntity createCategory(CategoryEntity categoryEntity) {
//		return categoryRepository.save(categoryEntity);
//	}
	
	@Override
	public List<CategoryEntity> createCategoryEntities(List<CategoryEntity> categoryEntities) {
		return categoryRepository.saveAll(categoryEntities);
	}

	@Override
	public CategoryEntity updateCategory(Long id, CategoryEntity updatedCategoryEntity) {
		return categoryRepository.findById(id)
				.map(category -> {
                    category.setCategoryName(updatedCategoryEntity.getCategoryName());
                    return categoryRepository.save(category);
                }).orElseThrow(() -> new CategoryNotFoundException(id));
    }

	@Override
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}
}
