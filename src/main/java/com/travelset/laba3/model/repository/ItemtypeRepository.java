package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.Itemtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemtypeRepository extends JpaRepository<Itemtype, Integer> {
    Itemtype findFirstByOrderByIdAsc();
    boolean existsById(int id);
}