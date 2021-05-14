package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findFirstByOrderByIdAsc();
    boolean existsById(int id);
}