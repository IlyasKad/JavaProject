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

        //WHEN
        travelSet1.addItem(backpack1);

        //THEN
        Item expected = travelSet1.items.get(0);
        assertEquals(expected, backpack1);
    }

    @Test
    void deleteItem() {
        //GIVEN
        Backpack backpack = new Backpack("backpack", 1, 25);
        TravelSet travelSet1 = new TravelSet();
        travelSet1.addItem(backpack);

        //WHEN
        travelSet1.deleteItem(backpack);

        //THEN
        assertTrue(travelSet1.items.isEmpty());
    }

    @Test
    void testToString() {
        //GIVEN
        TravelSet travelSet = new TravelSet();
        Backpack backpack4 = new Backpack("backpack4", 10, 25);
        backpack4.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
        travelSet.addItem(backpack4);

        //WHEN
        String actual = travelSet.toString();

        //THEN
        String expected = "List of travel set items: \n" +
                "List of backpack4 items: \n" +
                "\tDrink: MILK,5.0,1000.0,1.0.\n";

        assertEquals(expected, actual);
    }
}