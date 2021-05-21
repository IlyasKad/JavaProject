package com.travelset.laba3.controllers;

import com.travelset.laba3.model.entity.Itemtype;
import com.travelset.laba3.services.ItemtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ItemtypeController {

    private ItemtypeService itemtypeService;

    @Autowired
    public ItemtypeController(ItemtypeService itemtypeService) {
        this.itemtypeService = itemtypeService;
    }

    public Itemtype getItemtypeById(Integer id) {
        return itemtypeService.getItemtypeById(id);
    }

    public List<Itemtype> getAllItemtypes() {
        return itemtypeService.getAllItemtypes();
    }

    public Itemtype saveItemtype(Itemtype itemtype) {
        return itemtypeService.saveItemtype(itemtype);
    }

    public void deleteItemtype(int id) {
        itemtypeService.deleteItemtype(id);
    }

    public Itemtype updateItemtype(Itemtype itemtype) {
        return itemtypeService.updateItemtype(itemtype);
    }


}
