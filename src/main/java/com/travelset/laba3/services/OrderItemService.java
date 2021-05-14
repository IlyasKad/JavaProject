package com.travelset.laba3.services;

import com.travelset.laba3.model.entity.Item;
import com.travelset.laba3.model.entity.Order;
import com.travelset.laba3.model.entity.OrderItem;
import java.util.List;

public interface OrderItemService {
    OrderItem getOrderItemById(Integer id);
    List<OrderItem> getAllOrderItemsByOrder(Order order);
    OrderItem getByOrderAndItem(Order order, Item item);
    void deleteOrderItem(int id);
    void createOrUpdateOrderItem(int orderId, int itemId, int quantity);
}
