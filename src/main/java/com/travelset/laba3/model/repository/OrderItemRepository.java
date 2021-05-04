package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    OrderItem findFirstByOrderByIdAsc();
}