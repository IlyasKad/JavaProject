package travel;

import food.Drinks;
import food.DryRation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TravelSetTest {

    @Test
    void addItem() {
        //GIVEN
        Backpack backpack1 = new Backpack("backpack1", 10, 25);
        TravelSet travelSet1 = new TravelSet();

        //THEN
        travelSet1.addItem(backpack1);


        assertTrue(true);
    }

    @Test
    void deleteItem() {

    }

    @Test
    void testToString() {

    }
}