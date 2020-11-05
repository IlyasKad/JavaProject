package travel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DishesTest {

    @Test
    void testToString() {
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
    void testEquals() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);
        Dishes milk2 = new Dishes(Dishes.Type.PLATE, 1);

        //WHEN
        boolean actual = dishes1.equals(milk2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void sumItem() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);

        //WHEN
        Dishes milk2 = new Dishes(Dishes.Type.PLATE, 1);

        dishes1.sumItem(milk2);

        //THEN
        Dishes expected = new Dishes(Dishes.Type.PLATE, 2);

        assertEquals(dishes1, expected);
    }
}