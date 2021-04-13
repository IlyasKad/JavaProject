package com.travelset.controllers;

import com.travelset.services.OrderlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderlineController {
    @Autowired
    private OrderlineService orderlineService;

    public void createOrUpdateOrderline(int orderId, int itemId, int quantity){
        orderlineService.createOrUpdateOrderline(orderId, itemId, quantity);
    }
}
