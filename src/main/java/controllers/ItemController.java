package controllers;

import models.Item;
import services.ItemService;


public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    public void create(Item item) {
        itemService.create(item);
    }

    public Item findById(int id) {
        return  itemService.findById(id);
    }

}
