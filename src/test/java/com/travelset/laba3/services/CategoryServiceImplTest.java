package com.travelset.laba3.services;

import com.travelset.laba3.context.TestConfig;
import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Category;
import com.travelset.laba3.model.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {TestConfig.class})
@AutoConfigureDataJpa
public class CategoryServiceImplTest {

    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setup() {
        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    void getCategoryById_WhenThisCategoryExists() {
        Category expected = new Category();
        int id = 1;
        expected.setId(id);
        expected.setName("Food");
        when(categoryRepository.findById(id)).thenReturn(java.util.Optional.of(expected));
        Category actual = categoryService.getCategoryById(id);
        Assertions.assertEquals(expected, actual);
        verify(categoryRepository, times(1)).findById(1);
    }

    @Test
    void getCategoryById_WhenThisCategoryNotExists_ThenNoSuchEntityElementException() {
        Category expected = new Category();
        int id = 1;
        int wrongId = 2;
        expected.setId(id);
        expected.setName("Food");
        when(categoryRepository.findById(id)).thenReturn(Optional.of(expected));
        when(categoryRepository.findById(wrongId)).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchEntityElementException.class,
                () -> categoryService.getCategoryById(wrongId));
    }

    @Test
    void getAllCategories() {
        //GIVEN
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("Food");
        Category category2 = new Category();
        category2.setId(2);
        category2.setName("Medicine");
        List<Category> expected = new ArrayList<>();
        expected.add(category1);
        expected.add(category2);
        when(categoryRepository.findAll()).thenReturn(expected);
        //WHEN
        List<Category> actual = categoryService.getAllCategories();
        //THEN
        Assertions.assertIterableEquals(expected, actual,
                "The service returned list of categories which was not equals expected");
    }

    @Test
    void saveCategory_WhenThisCategoryNotExists() {
        Category expected = new Category();
        expected.setName("Food");
        when(categoryRepository.save(expected)).thenReturn(expected);
        Category actual = categoryService.saveCategory(expected);
        Assertions.assertEquals(expected, actual);
        verify(categoryRepository, times(1)).save(actual);
    }


    @Test
    void When_deleteCategory_Expect_Removed() {
        Category expected = new Category();
        int id = 1;
        expected.setName("Food");
        when(categoryRepository.existsById(id)).thenReturn(true).thenReturn(true);
        //doThrow().when(categoryRepository).delete(expected);
        doNothing().when(categoryRepository).deleteById(id);
        categoryService.deleteCategory(id);
        verify(categoryRepository, times(1)).deleteById(id);
    }


    @Test
    void deleteCategoryById_WhenThisCategoryNotExists_ThenNoSuchEntityElementException() {
        Category expected = new Category();
        int id = 1;
        int wrongId = 2;
        expected.setId(id);
        expected.setName("Food");
        when(categoryRepository.existsById(id)).thenReturn(false);
        doNothing().when(categoryRepository).deleteById(wrongId);
        verify(categoryRepository, times(0)).deleteById(id);
        Assertions.assertThrows(NoSuchEntityElementException.class,
                () -> categoryService.deleteCategory(wrongId));
    }




}
