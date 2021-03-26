package controllers;

import models.Item;
import org.springframework.stereotype.Controller;
import services.ItemService;

@Controller
public class ItemController {
    private final ItemService itemService;
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
