package controllers;

import models.database.ItemRepository;
import models.database.SubcategoryRepository;

import java.sql.SQLException;

public class ItemController {
    private ItemRepository itemRepository;
    private SubcategoryRepository subcategoryRepository;

    public ItemController(ItemRepository itemRepository) throws SQLException {
        this.itemRepository = new ItemRepository();
    }

    public String create(String itemName, int subcategoryId){
        String message;
        try {
            itemRepository.create(itemName, subcategoryId);
            message = "Item is created";
        } catch (SQLException throwables) {
            message = "Error in creating items";
        }
        return message;
    }
}
