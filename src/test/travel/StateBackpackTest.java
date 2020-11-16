package travel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateBackpackTest {

    @Test
    void When_UseToString_MessageFormat() {
        //GIVEN
        StateBackpack stateBackpack = StateBackpack.EMPTY;

        //WHEN
        String actual = stateBackpack.toString();

        //THEN
        String expected = "State of backpack is empty.";

        assertEquals(expected, actual);
    }

    @Test
    void When_GetName_NamesEquals() {
        //GIVEN
        StateBackpack stateBackpack = StateBackpack.EMPTY;

        //WHEN
        String actual = stateBackpack.getName();

        //THEN
        String expected = "empty";

        assertEquals(expected, actual);
    }
}