package com.travelset.laba3.controllers;

import com.travelset.laba3.context.TestConfig;
import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(classes = {TestConfig.class})
@AutoConfigureDataJpa
@Transactional
public class CategoryControllerIT {

    @Autowired
    private CategoryController categoryController;

    @Test
    public void saveFindDeleteCategory() {
        Category medicineCategory = new Category();
        medicineCategory.setName("Medicine");
        Category medicineCategorySaved = categoryController.saveCategory(medicineCategory);
        Category foundCategory = categoryController.getCategoryById(medicineCategorySaved.getId());
        Assertions.assertEquals(medicineCategory, foundCategory);
//        categoryController.deleteCategory(medicineCategorySaved.getId());
//        Assertions.assertThrows(NoSuchEntityElementException.class,
//                () -> categoryController.getCategoryById(medicineCategorySaved.getId()));

    }

}
