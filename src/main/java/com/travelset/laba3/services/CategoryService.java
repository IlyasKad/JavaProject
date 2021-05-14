package com.travelset.laba3.services;

import com.travelset.laba3.model.entity.Category;
import java.util.List;

public interface CategoryService {
    Category getCategoryById(Integer id);
    List<Category> getAllCategories();
    Category saveCategory(Category category);
    void deleteCategory(int id);
    Category updateCategory(Category category);
}
