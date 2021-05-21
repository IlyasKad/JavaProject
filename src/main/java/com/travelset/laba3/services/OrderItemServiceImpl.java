package com.travelset.laba3.services;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.exceptions.NotEnoughBackpackCapacityException;
import com.travelset.laba3.model.entity.Item;
import com.travelset.laba3.model.entity.Order;
import com.travelset.laba3.model.entity.OrderItem;
import com.travelset.laba3.model.repository.ItemRepository;
import com.travelset.laba3.model.repository.OrderRepository;
import com.travelset.laba3.model.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository,
                                OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public OrderItem getOrderItemById(Integer id) {
        return orderItemRepository.findById(id).
                orElseThrow(()->new NoSuchEntityElementException(OrderItem.class, id));
    }

    @Override
    public List<OrderItem> getAllOrderItemsByOrder(Order order) {
        return orderItemRepository.findByOrder(order);
    }
    @Override
    public OrderItem getByOrderAndItem(Order order, Item item) {
        return orderItemRepository.findByOrderAndItem(order, item).get(0);
    }


    @Override
    public void deleteOrderItem(int id) {
        if(!orderItemRepository.existsById(id)) {
            throw new NoSuchEntityElementException(OrderItem.class,id);
        }
        orderItemRepository.deleteById(id);
    }

    private void checkBackpackHasEnoughCapacity(Order order, Item item, int quantity){
        double totalItemWeight = order.getOrderItems().stream().
                reduce(0.0, (x,y)-> x + y.getItem().getWeight() * y.getQuantity(), Double::sum);
        if (totalItemWeight + item.getWeight() * quantity > order.getBackpack().getMaxCapacity()) {
            throw new NotEnoughBackpackCapacityException(order.getBackpack(), totalItemWeight,
                    item.getWeight() * quantity);
        }
    }

    @Override
    public void createOrUpdateOrderItem(int orderId, int itemId, int quantity){
        Order order = orderRepository.findById(orderId).
                orElseThrow(()->new NoSuchEntityElementException(Order.class, orderId));
        Item item = itemRepository.findById(itemId).
                orElseThrow(()->new NoSuchEntityElementException(Item.class, itemId));
        checkBackpackHasEnoughCapacity(order, item, quantity);
        OrderItem orderItem = order.getOrderItems().stream().
                filter(x -> x.getItem().equals(item)).findFirst().orElse(null);
        if (orderItem != null) {
            orderItem.setQuantity(orderItem.getQuantity() + quantity);
        } else {
            orderItem = new OrderItem(order, item, quantity);
        }
        orderItemRepository.save(orderItem);
    }


//    @Override
//    public void createOrUpdateOrderline(int orderId, int itemId, int quantity){
//        Order order = orderRepository.findById(orderId).
//                orElseThrow(()->new NoSuchEntityElementException(Order.class, orderId));
//        Item item = itemRepository.findById(itemId).
//                orElseThrow(()->new NoSuchEntityElementException(Item.class, itemId));
//        double totalItemWeight = 0;
//        Orderline orderline = null;
//        for (Orderline line : order.getOrderlines())
//        {
//            totalItemWeight += line.getItem().getWeight() * line.getQuantity();
//            if (line.getItem().getId() == item.getId())
//            {
//                orderline = line;
//            }
//        }
//        if (totalItemWeight + item.getWeight() * quantity <= order.getBackpack().getMaxCapacity())
//        {
//            if (orderline!=null)
//            {
//                orderline.setQuantity(orderline.getQuantity() + quantity);
//                orderlineRepository.save(orderline);
//            }
//            else
//            {
//                orderline = new Orderline();
//                orderline.setOrder(order);
//                orderline.setQuantity(quantity);
//                orderline.setItem(item);
//                orderlineRepository.save(orderline);
//            }
//        }else{
//            throw new NotEnoughBackpackCapacityException(order.getBackpack(), totalItemWeight,
//                    item.getWeight() * quantity);
//        }
//    }


}
