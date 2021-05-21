package com.travelset.laba3.controllers;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Category;
import com.travelset.laba3.model.entity.Item;
import com.travelset.laba3.model.entity.Order;
import com.travelset.laba3.model.entity.OrderItem;
import com.travelset.laba3.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderItemController {

    private OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    public OrderItem getOrderItemById(int id){
        return orderItemService.getOrderItemById(id);
    }


    public OrderItem getByOrderAndItem(Order order, Item item) {
        return orderItemService.getByOrderAndItem(order, item);
    }

    public void deleteOrderitem(int id){
        orderItemService.deleteOrderItem(id);
    }

    public void createOrUpdateOrderItem(int orderId, int itemId, int quantity){
        orderItemService.createOrUpdateOrderItem(orderId, itemId, quantity);
    }



}
