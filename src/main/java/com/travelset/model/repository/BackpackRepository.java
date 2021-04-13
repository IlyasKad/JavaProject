package com.travelset.model.repository;

import com.travelset.model.entity.Backpack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackpackRepository extends JpaRepository<Backpack, Integer> {

}