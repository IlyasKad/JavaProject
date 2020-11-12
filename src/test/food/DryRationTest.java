package food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DryRationTest {

    @Test
    void whenEatDryRationThenWeightDecrease() {
        //GIVEN
        double weight = 1;
        DryRation bread1 = new DryRation(DryRation.Type.BREAD, weight, 100);

        //WHEN
        double weightToEat = 0.3;
        bread1.eat(weightToEat);

        //THEN
        double actual = weight - weightToEat;
        double expected = bread1.weight;
        assertEquals(expected, actual);
    }

    @Test
    void whenUseToStringThenMessageFormat() {
        //GIVEN
        double weight = 1;
        DryRation bread1 = new DryRation(DryRation.Type.BREAD, weight, 100);

        //WHEN

        String actual = bread1.toString();

        //THEN
        String expected = "Dry ration: BREAD,1.0,100.0.";

        assertEquals(expected, actual);
    }


    @Test
    void whenObjectsContentSameThenEqualsTrue() {
        //GIVEN
        DryRation bread1 = new DryRation(DryRation.Type.BREAD, 1, 100);
        DryRation bread2 = new DryRation(DryRation.Type.BREAD, 1, 100);

        //WHEN
        boolean actual = bread1.equals(bread2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void whenSumItemsThenWeightCaloriesIncrease() {
        //GIVEN
        DryRation bread1 = new DryRation(DryRation.Type.BREAD, 1, 100);

        //WHEN
        DryRation milk2 = new DryRation(DryRation.Type.BREAD, 1, 100);

        bread1.sumItem(milk2);

        //THEN
        DryRation expected = new DryRation(DryRation.Type.BREAD, 2, 200);

        assertEquals(bread1, expected);
    }

    @Test
    void whenObjectNullThenEqualsFalse() {
        //GIVEN
        DryRation bread1 = new DryRation(DryRation.Type.BREAD, 1, 100);
        DryRation bread2 = null;

        //WHEN
        boolean actual = bread1.equals(bread2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void whenObjectThisThenEqualsTrue() {
        //GIVEN
        DryRation bread1 = new DryRation(DryRation.Type.BREAD, 1, 100);
        DryRation bread2 = bread1;

        //WHEN
        boolean actual = bread1.equals(bread2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void whenObjectsContentVariousThenEqualsFalse() {
        //GIVEN
        DryRation bread1 = new DryRation(DryRation.Type.BREAD, 1, 100);
        DryRation bread2 = new DryRation(DryRation.Type.ORANGE, 1, 100);

        //WHEN
        boolean actual = bread1.equals(bread2);

        //THEN
        assertFalse(actual);
    }
    
}