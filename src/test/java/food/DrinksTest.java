package food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DrinksTest {

    @Test
    void When_EatDrinks_WeightDecrease() {
        //GIVEN
        double weight = 1;
        Drinks milk1 = new Drinks(Drinks.Type.MILK, weight, 100, 1);

        //WHEN
        double weightToEat = 0.3;
        milk1.eat(weightToEat);

        //THEN
        double actual = weight - weightToEat;
        double expected = milk1.weight;
        assertEquals(expected, actual);
    }




    @Test
    void When_ObjectsContentSame_EqualsTrue() {
        //GIVEN
        Drinks milk1 = new Drinks(Drinks.Type.MILK, 1, 100, 1);
        Drinks milk2 = new Drinks(Drinks.Type.MILK, 1, 100, 1);

        //WHEN
        boolean actual = milk1.equals(milk2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void When_ObjectNull_EqualsFalse() {
        //GIVEN
        Drinks milk1 = new Drinks(Drinks.Type.MILK, 1, 100, 1);
        Drinks milk2 = null;

        //WHEN
        boolean actual = milk1.equals(milk2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void When_SumItems_WeightAndCaloriesIncrease() {
        //GIVEN
        Drinks milk1 = new Drinks(Drinks.Type.MILK, 1, 100, 1);

        //WHEN
        Drinks milk2 = new Drinks(Drinks.Type.MILK, 1, 100, 1);

        milk1.sumItem(milk2);

        //THEN
        Drinks expected = new Drinks(Drinks.Type.MILK, 2, 200, 1);

        assertEquals(milk1, expected);
    }

    @Test
    void When_ObjectThis_EqualsTrue() {
        //GIVEN
        Drinks milk1 = new Drinks(Drinks.Type.MILK, 1, 100, 1);
        Drinks milk2 = milk1;

        //WHEN
        boolean actual = milk1.equals(milk2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void When_ObjectsContentVarious_EqualsFalse() {
        //GIVEN
        Drinks milk1 = new Drinks(Drinks.Type.MILK, 1, 100, 1);
        Drinks milk2 = new Drinks(Drinks.Type.WATER, 1, 100, 1);

        //WHEN
        boolean actual = milk1.equals(milk2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void When_UseToString_MessageFormat() {
        //GIVEN
        double weight = 1;
        Drinks milk1 = new Drinks(Drinks.Type.MILK, weight, 100, 1);

        //WHEN

        String actual = milk1.toString();

        //THEN
        String expected = "Drink: MILK,1.0,100.0,1.0.";

        assertEquals(expected, actual);
    }
}