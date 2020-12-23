package medicines;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PillTest {

    @Test
    void When_EatPill_WeightDecrease() {
        //GIVEN
        double weight = 1;
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, weight);

        //WHEN
        double weightToEat = 0.3;
        pill1.eat(weightToEat);

        //THEN
        double actual = weight - weightToEat;
        double expected = pill1.getWeight();
        assertEquals(expected, actual);
    }

    @Test
    void When_UseToString_MessageFormat() {
        //GIVEN
        double weight = 1;
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, weight);

        //WHEN

        String actual = pill1.toString();

        //THEN
        String expected = "Pill: LOPERAMIDE,1.0.";

        assertEquals(expected, actual);
    }


    @Test
    void When_ObjectsContentSame_EqualsTrue() {
        //GIVEN
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, 1);
        Pill pill2 = new Pill(Pill.Type.LOPERAMIDE, 1);

        //WHEN
        boolean actual = pill1.equals(pill2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void When_SumItems_WeightIncrease() {
        //GIVEN
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, 1);

        //WHEN
        Pill pill2 = new Pill(Pill.Type.LOPERAMIDE, 1);

        pill1.sumItem(pill2);

        //THEN
        Pill expected = new Pill(Pill.Type.LOPERAMIDE, 2);

        assertEquals(pill1, expected);
    }

    @Test
    void When_ObjectNull_EqualsFalse() {
        //GIVEN
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, 1);
        Pill pill2 = null;

        //WHEN
        boolean actual = pill1.equals(pill2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void When_ObjectThis_EqualsTrue() {
        //GIVEN
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, 1);
        Pill pill2 = pill1;

        //WHEN
        boolean actual = pill1.equals(pill2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void When_ObjectsContentVarious_EqualsFalse() {
        //GIVEN
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, 1);
        Pill pill2 = new Pill(Pill.Type.ASPIRIN, 1);

        //WHEN
        boolean actual = pill1.equals(pill2);

        //THEN
        assertFalse(actual);
    }
}