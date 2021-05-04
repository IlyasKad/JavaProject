package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.Backpack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackpackRepository extends JpaRepository<Backpack, Integer> {
    Backpack findFirstByOrderByIdAsc();
}