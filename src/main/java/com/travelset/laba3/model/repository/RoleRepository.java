package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findFirstByOrderByIdAsc();
}