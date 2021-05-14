package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findFirstByOrderByIdAsc();
    boolean existsById(int id);

}