package com.travelset.laba3.controllers;


import com.travelset.laba3.model.entity.Category;
import com.travelset.laba3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Category getCategoryById(Integer id) {
        return categoryService.getCategoryById(id);
    }

    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    public Category saveCategory(Category category){
        return categoryService.saveCategory(category);
    }

    public void deleteCategory(int id){
        categoryService.deleteCategory(id);
    }

    public Category updateCategory(Category category){
        return categoryService.updateCategory(category);
    }



}
