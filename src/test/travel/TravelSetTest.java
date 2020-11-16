package travel;

//import food.Drinks;

import food.Drinks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelSetTest {

    @Test
    void When_AddItemToSet_ItemExistInSet() {
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
    void When_DeleteItemFromSet_ItemNotExistInSet() {
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
    void When_DeleteItemThatNotExistInSet_ResultFalse() {
        //GIVEN
        Backpack backpack = new Backpack("backpack", 1, 25);
        Backpack backpack2 = new Backpack("backpack", 1, 25);
        TravelSet travelSet1 = new TravelSet();
        travelSet1.addItem(backpack);

        //WHEN
        boolean actual = travelSet1.deleteItem(backpack2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void When_UseToString_MessageFormat() {
        //GIVEN
        TravelSet travelSet = new TravelSet();
        Backpack backpack4 = new Backpack("backpack4", 10, 25);
        backpack4.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
        backpack4.add(Drinks.Type.valueOf("WATER"), 5, 1000, 1);
        travelSet.addItem(backpack4);

        //WHEN
        String actual = travelSet.toString();

        //THEN
        String expected = "List of travel set items: \n" +
                "List of backpack4 items: \n" +
                "\tDrink: MILK,5.0,1000.0,1.0.\n" +
                "\tDrink: WATER,5.0,1000.0,1.0.\n";

        assertEquals(expected, actual);
    }

    @Test
    void When_AddItemToSetNotValid_AdditionFalse() {
        //GIVEN
        Backpack backpack1 = new Backpack("backpack1", 10, 25);
        TravelSet travelSet1 = new TravelSet();

        //WHEN
        travelSet1.addItem(backpack1);

        //THEN
        boolean actual = travelSet1.addItem(backpack1);;
        assertFalse(actual);
    }
}