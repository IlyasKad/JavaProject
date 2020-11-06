package travel;

import medicines.Pill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DishesTest {

    @Test
    void whenUseToString() {
        //GIVEN
        double weight = 1;
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, weight);

        //WHEN

        String actual = dishes1.toString();

        //THEN
        String expected = "Dishes: PLATE,1.0.";

        assertEquals(expected, actual);
    }


    @Test
    void whenEqualsDishes() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);
        Dishes dishes2 = new Dishes(Dishes.Type.PLATE, 1);

        //WHEN
        boolean actual = dishes1.equals(dishes2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void whenSumItem() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);

        //WHEN
        Dishes milk2 = new Dishes(Dishes.Type.PLATE, 1);

        dishes1.sumItem(milk2);

        //THEN
        Dishes expected = new Dishes(Dishes.Type.PLATE, 2);

        assertEquals(dishes1, expected);
    }

    @Test
    void whenEqualsWithNull() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);
        Dishes dishes2 = null;

        //WHEN
        boolean actual = dishes1.equals(dishes2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void whenEqualsResultFalse() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);
        Dishes dishes2 = new Dishes(Dishes.Type.PLATE, 2);

        //WHEN
        boolean actual = dishes1.equals(dishes2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void whenEqualsWithThis() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);
        Dishes dishes2 = dishes1;

        //WHEN
        boolean actual = dishes1.equals(dishes2);

        //THEN
        assertTrue(actual);
    }
}