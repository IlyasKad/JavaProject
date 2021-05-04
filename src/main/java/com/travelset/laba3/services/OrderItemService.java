package com.travelset.laba3.services;

import com.travelset.laba3.model.entity.OrderItem;

public interface OrderItemService {
    OrderItem getOrderItem(int id);
    void createOrUpdateOrderItem(int orderId, int itemId, int quantity);
}
