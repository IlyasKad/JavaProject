package com.travelset.laba3.controllers;

import com.travelset.laba3.model.entity.Item;
import com.travelset.laba3.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    public Item getItemById(Integer id) {
        return itemService.getItemById(id);
    }

    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    public Item saveItem(Item item){
        return itemService.saveItem(item);
    }

    public void deleteItem(int id){
        itemService.deleteItem(id);
    }

    public Item updateItem(Item item){
        return itemService.updateItem(item);
    }



}
