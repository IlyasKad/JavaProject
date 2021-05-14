package com.travelset.laba3.model.repository;

import com.travelset.laba3.model.entity.Item;
import com.travelset.laba3.model.entity.Order;
import com.travelset.laba3.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    OrderItem findFirstByOrderByIdAsc();
    List<OrderItem> findByOrder(Order order);
    List<OrderItem> findByOrderAndItem(Order order, Item item);
    boolean existsById(int id);
}