package services;

import models.Order;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void create(Order order) {
        orderRepository.create(order);
    }
}
