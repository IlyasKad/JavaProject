package com.travelset.laba3.services;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Item;

import java.util.List;

public interface ItemService {

   Item getItemById(Integer id);

    List<Item> getAllItems();

    Item saveItem(Item item);

    void deleteItem(int id);

    Item updateItem(Item item);
}
