package com.travelset.laba3.controllers;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.OrderItem;
import com.travelset.laba3.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderItemController {

    private OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    public OrderItem getOrderItem(int id){
        return orderItemService.getOrderItem(id);
    }

    public void createOrUpdateOrderItem(int orderId, int itemId, int quantity){
        orderItemService.createOrUpdateOrderItem(orderId, itemId, quantity);
    }
}
