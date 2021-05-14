package com.travelset.laba3.exceptions;

import com.travelset.laba3.model.entity.Backpack;

public class NotEnoughBackpackCapacityException extends RuntimeException{
    public NotEnoughBackpackCapacityException(Backpack backpack, double totalItemWeight, double weightToAdd) {
        super("Backpack does not have enough capacity! (Free space: "
                + (backpack.getMaxCapacity() - totalItemWeight) +
                ". But You want to add " + weightToAdd + ")");
    }
}
