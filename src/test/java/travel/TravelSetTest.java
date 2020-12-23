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

//    @Test
//    void When_CountSumWeightOfTravelSet_TotalWeightOfTravelSet() {
//        //GIVEN
//        Backpack backpack1 = new Backpack("backpack1", 10, 25);
//        Backpack backpack2 = new Backpack("backpack2", 10, 25);
//        Backpack backpack3 = new Backpack("backpack3", 10, 25);
//
//        TravelSet travelSet1 = new TravelSet();
//
//        try {
//            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
//            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
//            backpack1.add(Drinks.Type.valueOf("WATER"), 1, 0, 1);
//            backpack2.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
//            backpack2.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
//            backpack2.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
//            backpack2.add(Dishes.Type.valueOf("PLATE"),3);
//            backpack3.add(Drinks.Type.valueOf("CAPPUCCINO"), 6, 1000, 1);
//            backpack3.add(Drinks.Type.valueOf("MILK"), 3, 1000, 1);
//            backpack3.add(Drinks.Type.valueOf("MILK"), 3, 1000, 1);
//            backpack3.add(Dishes.Type.valueOf("PLATE"),2);
//        } catch(Exception e){
//            System.out.println(e);
//        }
//
//
//        travelSet1.addItem(backpack1);
//        travelSet1.addItem(backpack2);
//        travelSet1.addItem(backpack3);
//
//        //WHEN
//        double expected = travelSet1.sumWeightTravelSet();
//        double actual = 39;
//
//        //THEN
//        assertEquals(expected, actual);
//
//    }

//    @Test
//    void When_CountSumWeightOfEmptyTravelSet_TotalWeightOfTravelSetEqualZero() {
//        //GIVEN
//        Backpack backpack1 = new Backpack("backpack1", 10, 25);
//        Backpack backpack2 = new Backpack("backpack2", 10, 25);
//        Backpack backpack3 = new Backpack("backpack3", 10, 25);
//
//        TravelSet travelSet1 = new TravelSet();
//
//        travelSet1.addItem(backpack1);
//        travelSet1.addItem(backpack2);
//        travelSet1.addItem(backpack3);
//
//        //WHEN
//        double expected = travelSet1.sumWeightTravelSet();
//        double actual = 0;
//
//        //THEN
//        assertEquals(expected, actual);
//
//    }
}