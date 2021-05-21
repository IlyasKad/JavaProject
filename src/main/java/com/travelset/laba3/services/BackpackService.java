package com.travelset.laba3.services;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Backpack;

import java.util.List;

public interface BackpackService {
    Backpack getBackpackById(Integer id);

   List<Backpack> getAllBackpacks();

   Backpack saveBackpack(Backpack backpack);

    void deleteBackpack(int id);

   Backpack updateBackpack(Backpack backpack);
}
