//package travel;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TravelSetIT {
//
//    Backpack backpack1 = Mockito.mock(Backpack.class);
//    Backpack backpack2 = Mockito.mock(Backpack.class);
//    TravelSet travelSet = new TravelSet();
//
//    @Test
//    public void When_SumWeightTravelSet_GetCommonWeight() {
//        //GIVEN
//        Mockito.when(backpack1.getWeight()).thenReturn(10.0);
//        Mockito.when(backpack2.getWeight()).thenReturn(5.0);
//        travelSet.items.add(backpack1);
//        travelSet.items.add(backpack2);
//
//        //WHEN
//        double actual = travelSet.sumWeightTravelSet();
//
//        //THEN
//        double expected = 15.0;
//        Mockito.verify(backpack1).getWeight();
//        Mockito.verify(backpack2).getWeight();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void When_SumWeightEmptyTravelSet_GetZero() {
//        //GIVEN
//
//        //WHEN
//        double actual = travelSet.sumWeightTravelSet();
//
//        //THEN
//        double expected = 0.0;
//        assertEquals(expected, actual);
//    }
//}
