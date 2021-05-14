package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findFirstByOrderByIdAsc();
    boolean existsById(int id);
}