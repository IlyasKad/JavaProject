package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Permission findFirstByOrderByIdAsc();
    boolean existsById(int id);
}