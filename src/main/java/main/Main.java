
package main;


import controllers.ItemController;
import models.Item;
import models.ItemType;
import repository.ItemRepository;
import services.ItemService;
import services.ItemServiceImpl;

import java.sql.SQLException;

public class Main {

    public static void testItemRepository() throws SQLException {
        ItemRepository r = new ItemRepository();
        ItemType type = new ItemType();
        type.id = 1;
        r.create(new Item("Milk2", type, 100, 100));

        Item itemFound = r.findById(1);
        if(itemFound!=null){
            System.out.println("description: " + itemFound.description);
            System.out.println("itemType name: " + itemFound.itemType.name);
            System.out.println("category name: " + itemFound.itemType.category.name);
        }else{
            System.out.println("Item not found");
        }
    }

    public static void testItemController() throws SQLException {
        ItemRepository itemRepository = new ItemRepository();
        ItemService itemService = new ItemServiceImpl(itemRepository);
        ItemController itemController = new ItemController(itemService);

        Item itemFound = itemController.findById(1);
        if(itemFound!=null){
            System.out.println("description: " + itemFound.description);
            System.out.println("itemType name: " + itemFound.itemType.name);
            System.out.println("category name: " + itemFound.itemType.category.name);
        }else{
            System.out.println("Item not found");
        }
    }

    public static void main(String[] args) throws SQLException {
//        testItemRepository();
        testItemController();
    }
}
