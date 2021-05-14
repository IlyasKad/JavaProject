package com.travelset.laba3.services;

import com.travelset.laba3.model.entity.Order;
import java.util.List;

public interface OrderService {
    Order getOrderById(Integer id);
    List<Order> getAllOrders();
    Order saveOrder(Order order);
    void deleteOrder(int id);
    Order updateOrder(Order order);
}
