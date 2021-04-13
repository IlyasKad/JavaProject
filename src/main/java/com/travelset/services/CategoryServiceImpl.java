package com.travelset.services;

import com.travelset.model.entity.Category;
import com.travelset.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements  CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }
}
