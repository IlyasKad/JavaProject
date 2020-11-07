package medicines;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PillTest {

    @Test
    void whenEatPill() {
        //GIVEN
        double weight = 1;
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, weight);

        //WHEN
        double weightToEat = 0.3;
        pill1.eat(weightToEat);

        //THEN
        double actual = weight - weightToEat;
        double expected = pill1.weight;
        assertEquals(expected, actual);
    }

    @Test
    void whenUseToString() {
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
    void whenEqualsResultTrue() {
        //GIVEN
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, 1);
        Pill pill2 = new Pill(Pill.Type.LOPERAMIDE, 1);

        //WHEN
        boolean actual = pill1.equals(pill2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void whenSumItem() {
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
    void whenEqualsWithNull() {
        //GIVEN
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, 1);
        Pill pill2 = null;

        //WHEN
        boolean actual = pill1.equals(pill2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void whenEqualsWithThis() {
        //GIVEN
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, 1);
        Pill pill2 = pill1;

        //WHEN
        boolean actual = pill1.equals(pill2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void whenEqualsResultFalse() {
        //GIVEN
        Pill pill1 = new Pill(Pill.Type.LOPERAMIDE, 1);
        Pill pill2 = new Pill(Pill.Type.ASPIRIN, 1);

        //WHEN
        boolean actual = pill1.equals(pill2);

        //THEN
        assertFalse(actual);
    }
}