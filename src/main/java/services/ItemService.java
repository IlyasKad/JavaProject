package services;

import models.Item;

public interface ItemService {
    public void create(Item item);
    public Item findById(int id);

}
