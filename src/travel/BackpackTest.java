package travel;

import food.Drinks;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BackpackTest {

    @Test
    void getStateBackpack() {
    }

    @Test
    void setStateBackpack() {
    }

    @Test
    void getIterator() {
    }

    @Test
    void getWhoCarry() {
    }

    @Test
    void setWhoCarry() {
    }

    @Test
    void addTouristWhoCarry() {
    }

    @Test
    void add() {
        Backpack backpack = new Backpack("backpack", 1, 25);
        try {
            backpack.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
        } catch (ExceptionLimitOversize e) {
            e.printStackTrace();
        }
        Iterator<Item> iterator = backpack.getIterator();
        Item actual = iterator.next();
        Item expected = new Drinks(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
        assertEquals(expected, actual);
    }

    @Test
    void sumItem() {
    }

    @Test
    void deleteItem() {
    }

    @Test
    void testToString() {
    }

    @Test
    void saveToFile() {
    }

    @Test
    void openFromFile() {
    }

    @Test
    void toStringForFile() {
    }

    @Test
    void equalsByContent() {
    }
}