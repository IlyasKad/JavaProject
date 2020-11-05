package travel;

import food.Drinks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionLimitOversizeTest {
    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {

        ExceptionLimitOversize exception = assertThrows(ExceptionLimitOversize.class, () -> {
            Backpack backpack1 = new Backpack("backpack1", 10, 25);

            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("WATER"), 1, 0, 1);
            backpack1.add(Dishes.Type.valueOf("PLATE"),5);
        });

        String expectedMessage = "Oversize of limit. Max of weight = 25.0, current weight = 21.0, reminder of weight = 4.0";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }
}