package com.travelset.laba3.controllers;

import com.travelset.laba3.model.entity.Backpack;
import com.travelset.laba3.services.BackpackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BackpackController {
    private final BackpackService backpackService;

    @Autowired
    public BackpackController(BackpackService backpackService) {
        this.backpackService = backpackService;
    }

    public Backpack getBackpackById(Integer id) {
        return backpackService.getBackpackById(id);
    }

    public List<Backpack> getAllCategories(){
        return backpackService.getAllBackpacks();
    }

    public Backpack saveBackpack(Backpack backpack){
        return backpackService.saveBackpack(backpack);
    }

    public void deleteBackpack(int id){
        backpackService.deleteBackpack(id);
    }

    public Backpack updateBackpack(Backpack backpack){
        return backpackService.updateBackpack(backpack);
    }
}
