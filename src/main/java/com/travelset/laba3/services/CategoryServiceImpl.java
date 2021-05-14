package com.travelset.laba3.services;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Category;
import com.travelset.laba3.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements  CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).
                orElseThrow(()->new NoSuchEntityElementException(Category.class, id));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        if(!categoryRepository.existsById(id)) {
            throw new NoSuchEntityElementException(Category.class,id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Category category) {
        if(!categoryRepository.existsById(category.getId())) {
            throw new NoSuchEntityElementException(Category.class, category.getId());
        }
        return categoryRepository.save(category);
    }




}
