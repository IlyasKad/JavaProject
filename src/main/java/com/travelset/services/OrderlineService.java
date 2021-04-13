package com.travelset.services;

public interface OrderlineService {
    void createOrUpdateOrderline(int orderId, int itemId, int quantity);
}
