package travel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DishesTest {

    @Test
    void whenSumItemsThenWeightIncrease() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);

        //WHEN
        Dishes dishes2 = new Dishes(Dishes.Type.PLATE, 1);

        dishes1.sumItem(dishes2);

        //THEN
        Dishes expected = new Dishes(Dishes.Type.PLATE, 2);

        assertEquals(dishes1, expected);
    }

    @Test
    void whenObjectNullThenEqualsFalse() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);
        Dishes dishes2 = null;

        //WHEN
        boolean actual = dishes1.equals(dishes2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void whenObjectsContentVariousThenEqualsFalse() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);
        Dishes dishes2 = new Dishes(Dishes.Type.PLATE, 2);

        //WHEN
        boolean actual = dishes1.equals(dishes2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void whenObjectThisThenEqualsTrue() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);
        Dishes dishes2 = dishes1;

        //WHEN
        boolean actual = dishes1.equals(dishes2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void whenUseToStringThenMessageFormat() {
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
    void whenObjectsContentSameThenEqualsTrue() {
        //GIVEN
        Dishes dishes1 = new Dishes(Dishes.Type.PLATE, 1);
        Dishes dishes2 = new Dishes(Dishes.Type.PLATE, 1);

        //WHEN
        boolean actual = dishes1.equals(dishes2);

        //THEN
        assertTrue(actual);
    }
}