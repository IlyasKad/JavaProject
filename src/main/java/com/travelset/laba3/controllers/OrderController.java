package com.travelset.laba3.controllers;


import com.travelset.laba3.model.entity.Order;
import com.travelset.laba3.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order getOrderById(Integer id) {
        return orderService.getOrderById(id);
    }

    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    public Order saveOrder(Order order){
        return orderService.saveOrder(order);
    }

    public void deleteOrder(int id){
        orderService.deleteOrder(id);
    }

    public Order updateOrder(Order order){
        return orderService.updateOrder(order);
    }



}
