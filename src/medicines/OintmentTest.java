package medicines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OintmentTest {

    @Test
    void testToString() {
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
    void testEquals() {
        //GIVEN
        Ointment ointment1 = new Ointment(Ointment.Type.LEVOMEKOL, 1);
        Ointment ointment2 = new Ointment(Ointment.Type.LEVOMEKOL, 1);

        //WHEN
        boolean actual = ointment1.equals(ointment2);

        //THEN
        assertTrue(actual);
    }

    @Test
    void sumItem() {
        //GIVEN
        Ointment ointment1 = new Ointment(Ointment.Type.LEVOMEKOL, 1);

        //WHEN
        Ointment ointment2 = new Ointment(Ointment.Type.LEVOMEKOL, 1);

        ointment1.sumItem(ointment2);

        //THEN
        Ointment expected = new Ointment(Ointment.Type.LEVOMEKOL, 2);

        assertEquals(ointment1, expected);
    }
}