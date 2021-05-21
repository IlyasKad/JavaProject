package com.travelset.laba3.services;

import com.travelset.laba3.exceptions.NoSuchEntityElementException;
import com.travelset.laba3.model.entity.Category;
import com.travelset.laba3.model.entity.Itemtype;

import java.util.List;

public interface ItemtypeService {

   Itemtype getItemtypeById(Integer id);

   List<Itemtype> getAllItemtypes();

    Itemtype saveItemtype(Itemtype itemtype);

    void deleteItemtype(int id);

    Itemtype updateItemtype(Itemtype itemtype);


}
