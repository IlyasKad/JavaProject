package com.travelset.services;
import com.travelset.model.entity.Item;
import com.travelset.model.entity.Order;
import com.travelset.model.entity.Orderline;
import com.travelset.model.repository.ItemRepository;
import com.travelset.model.repository.OrderRepository;
import com.travelset.model.repository.OrderlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderlineServiceImpl implements  OrderlineService {

    @Autowired
    private OrderlineRepository orderlineRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void createOrUpdateOrderline(int orderId, int itemId, int quantity) {
        Order order = orderRepository.findById(orderId).get(); // TODO check if exists, exception
        Item item = itemRepository.findById(itemId).get();// TODO check if exists, exception

        double totalItemWeight = 0;
        Orderline orderLineExists = null;
        for (Orderline line : order.getOrderlines()) {
            totalItemWeight += line.getItem().getWeight() * line.getQuantity();
            if (line.getItem().getId() == item.getId()) {
                orderLineExists = line;
            }
        }

        if (totalItemWeight + item.getWeight() * quantity <= order.getBackpack().getMaxCapacity()) {
            if (orderLineExists != null) {
                orderLineExists.setQuantity(orderLineExists.getQuantity() + quantity);
                orderlineRepository.save(orderLineExists);
            } else {
                Orderline orderline = new Orderline();
                orderline.setOrder(order);
                orderline.setQuantity(quantity);
                orderline.setItem(item);
                orderlineRepository.save(orderline);
            }
        } else{
            // TODO exception
            String error = "Backpack does not have enough capacity! (Free space: "
                                + (order.getBackpack().getMaxCapacity() - totalItemWeight) +
                               ". But You want to add " + item.getWeight() * quantity + ")";
        }
    }
}
