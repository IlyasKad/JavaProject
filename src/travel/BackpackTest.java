package travel;

import food.Drinks;
import food.DryRation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BackpackTest {
    @Test
    void addTouristWhoCarry() {
        //GIVEN
        Tourist tourist1 = new Tourist("Nick");
        Backpack backpack1 = new Backpack("backpack1", 10, 25);

        //WHEN
        backpack1.addTouristWhoCarry(tourist1); // неперевизначений метод equals

        //THEN
        Tourist actual = backpack1.whoCarry.get(0);
        Tourist expected = tourist1;
        assertEquals(expected, actual);
    }

    @Test
    void add() {
        //GIVEN
        Backpack backpack = new Backpack("backpack", 1, 25);

        //WHEN
        try {
            backpack.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
        } catch (ExceptionLimitOversize e) {
            e.printStackTrace();
        }

        //THEN
        Iterator<Item> iterator = backpack.getIterator();
        Item actual = iterator.next();
        Item expected = new Drinks(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
        assertEquals(expected, actual);
    }


    @Test
    void deleteItem() {
        //GIVEN
        Backpack backpack = new Backpack("backpack", 1, 25);
        try {
            backpack.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
        } catch (ExceptionLimitOversize e) {
            e.printStackTrace();
        }

        //WHEN
        backpack.deleteItem(Drinks.Type.MILK);

        //THEN
        assertFalse(backpack.getIterator().hasNext());

    }

    @Test
    void testToString() {
        //GIVEN
        Backpack backpack4 = new Backpack("backpack4", 10, 25);
        try {
            backpack4.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);

        } catch(Exception e){
            System.out.println(e);
        }
        //WHEN

        String actual = backpack4.toString();

        //THEN
        String expected = "List of backpack4 items: \n" +
                "\tDrink: MILK,5.0,1000.0,1.0.\n";

        assertEquals(expected, actual);
    }

    @Test
    void equalsByContent() {
        //GIVEN
        Backpack backpack1 = new Backpack("backpack1", 10, 25);
        Backpack backpack3 = new Backpack("backpack3", 10, 25);

        try {
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
            backpack1.add(Dishes.Type.valueOf("PLATE"),5);
            backpack1.add(DryRation.Type.valueOf("BREAD"), 2, 1000);
        } catch(Exception e){
            System.out.println(e);
        }

        try {
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
            backpack3.add(Dishes.Type.valueOf("PLATE"),5);
            backpack3.add(DryRation.Type.valueOf("BREAD"), 2, 1000);
        } catch(Exception e){
            System.out.println(e);
        }

        //WHEN
        boolean actual = backpack1.equalsByContent(backpack3);

        //THEN
        assertTrue(actual);

    }

    @Test
    void testEquals() {
        //GIVEN
        Backpack backpack1 = new Backpack("backpack1", 10, 25);
        Backpack backpack3 = new Backpack("backpack3", 10, 25);

        try {
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
            backpack1.add(Dishes.Type.valueOf("PLATE"),5);
            backpack1.add(DryRation.Type.valueOf("BREAD"), 2, 1000);
        } catch(Exception e){
            System.out.println(e);
        }

        try {
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
            backpack3.add(Dishes.Type.valueOf("PLATE"),5);
            backpack3.add(DryRation.Type.valueOf("BREAD"), 2, 1000);
        } catch(Exception e){
            System.out.println(e);
        }

        //WHEN
        boolean actual = backpack1.equals(backpack3);

        //THEN
        assertFalse(actual);

    }

    @Test
    void sumItem() {
        //GIVEN
        Backpack backpack1 = new Backpack("backpack1", 10, 100);
        Backpack backpack2 = new Backpack("backpack2", 10, 100);

        try {
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("WATER"), 1, 0, 1);

        } catch(Exception e){
            System.out.println(e);
        }

        try {
            backpack2.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack2.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack2.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
            backpack2.add(Dishes.Type.valueOf("PLATE"),2);

        } catch(Exception e){
            System.out.println(e);
        }

        //WHEN


        backpack1.sumItem(backpack2);

        //THEN
        Backpack backpack3 = new Backpack("backpack1", 10, 100);

        try {
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("WATER"), 1, 0, 1);
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
            backpack3.add(Dishes.Type.valueOf("PLATE"),2);
        } catch(Exception e){
            System.out.println(e);
        }



        assertTrue(backpack1.equalsByContent(backpack3));
    }
}