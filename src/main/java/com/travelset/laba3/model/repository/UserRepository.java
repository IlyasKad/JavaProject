package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByOrderByIdAsc();
}