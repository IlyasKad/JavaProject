package controllers;

import models.Order;
import org.springframework.stereotype.Controller;
import services.OrderService;

@Controller
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    public void create(Order order) {
        orderService.create(order);
    }
}
