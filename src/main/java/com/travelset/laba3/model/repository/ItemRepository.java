package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findFirstByOrderByIdAsc();
    boolean existsById(int id);
}