package services;

import models.Item;

public interface ItemService {
    void create(Item item);
    Item findById(int id);
}
