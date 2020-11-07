package medicines;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OintmentTest {

    @Test
    void whenUseToString() {
        //GIVEN
        double weight = 1;
        Ointment ointment1 = new Ointment(Ointment.Type.LEVOMEKOL, weight);

        //WHEN

        String actual = ointment1.toString();

        //THEN
        String expected = "Ointment: LEVOMEKOL,1.0.";

        assertEquals(expected, actual);
    }


    @Test
    void whenEqualsResultTrue() {
        //GIVEN
        Ointment ointment1 = new Ointment(Ointment.Type.LEVOMEKOL, 1);
        Ointment ointment2 = new Ointment(Ointment.Type.LEVOMEKOL, 1);

        //WHEN
        boolean actual = ointment1.equals(ointment2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void whenSumItem() {
        //GIVEN
        Ointment ointment1 = new Ointment(Ointment.Type.LEVOMEKOL, 1);

        //WHEN
        Ointment ointment2 = new Ointment(Ointment.Type.LEVOMEKOL, 1);

        ointment1.sumItem(ointment2);

        //THEN
        Ointment expected = new Ointment(Ointment.Type.LEVOMEKOL, 2);

        assertEquals(ointment1, expected);
    }

    @Test
    void whenEqualsWithNull() {
        //GIVEN
        Ointment ointment1 = new Ointment(Ointment.Type.LEVOMEKOL, 1);
        Ointment ointment2 = null;

        //WHEN
        boolean actual = ointment1.equals(ointment2);

        //THEN
        assertFalse(actual);
    }

    @Test
    void whenEqualsWithThis() {
        //GIVEN
        Ointment ointment1 = new Ointment(Ointment.Type.LEVOMEKOL, 1);
        Ointment ointment2 = ointment1;

        //WHEN
        boolean actual = ointment1.equals(ointment2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void whenEqualsResultFalse() {
        //GIVEN
        Ointment ointment1 = new Ointment(Ointment.Type.LEVOMEKOL, 1);
        Ointment ointment2 = new Ointment(Ointment.Type.KETONAL, 1);

        //WHEN
        boolean actual = ointment1.equals(ointment2);

        //THEN
        assertFalse(actual);
    }
}