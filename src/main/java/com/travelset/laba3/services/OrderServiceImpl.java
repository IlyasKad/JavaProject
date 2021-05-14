package com.travelset.laba3.services;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Order;
import com.travelset.laba3.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class OrderServiceImpl implements  OrderService{
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).
                orElseThrow(()->new NoSuchEntityElementException(Order.class, id));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        if(!orderRepository.existsById(id)) {
            throw new NoSuchEntityElementException(Order.class,id);
        }
        orderRepository.deleteById(id);
    }

    @Override
    public Order updateOrder(Order order) {
        if(!orderRepository.existsById(order.getId())) {
            throw new NoSuchEntityElementException(Order.class, order.getId());
        }
        return orderRepository.save(order);
    }
}
