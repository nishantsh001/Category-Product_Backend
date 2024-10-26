package com.backend.service;

import com.backend.entity.CategoryEntity;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryEntity> getAllCategoryEntities(int Page_No, int Page_Size);
    Optional<CategoryEntity> getCategoryById(Long id);
//    CategoryEntity createCategory(CategoryEntity categoryEntity);
    List<CategoryEntity> createCategoryEntities(List<CategoryEntity> categoryEntities);
    CategoryEntity updateCategory(Long id, CategoryEntity updatedCategoryEntity);
    void deleteCategoryById(Long id);
}
