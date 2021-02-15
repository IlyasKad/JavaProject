//package travel;
//
//import food.Drinks;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class BackpackIT {
//    Item item1 = Mockito.mock(Item.class);
//    Backpack backpack = new Backpack("backpack", 0, 25);
//
//    @Test
//    public void When_AddItemToBackpack_ItemAddSuccessfully() {
//        //GIVEN
//        Mockito.when(item1.getWeight()).thenReturn(10.0);
//        Mockito.when(item1.getName()).thenReturn("milk");
//
//        //WHEN
//        backpack.addItem(item1);
//
//        //THEN
//        StateBackpack actualState = backpack.stateBackpack;
//        StateBackpack expectedState = StateBackpack.NOT_FULL;
//
//        ArrayList<Item> actual = backpack.getItems();
//        ArrayList<Item> expected = new ArrayList<>();
//
//        Double actualWeight = backpack.getWeight();
//        Double expectedWeight = 10.0;
//
//        Mockito.verify(item1, Mockito.times(1)).getWeight();
//        expected.add(item1);
//
//        assertEquals(expected, actual);
//        assertEquals(expectedState, actualState);
//        assertEquals(expectedWeight, actualWeight);
//    }
//
//    @Test
//    public void When_DeleteItemFromBackpack_BackpackNotContainItemAndReturnTrue() {
//        //GIVEN
//        Mockito.when(item1.getWeight()).thenReturn(10.0);
//        Mockito.when(item1.getName()).thenReturn("MILK");
//        ArrayList<Item> items = backpack.getItems();
//        items.add(item1);
//
//        //WHEN
//        Boolean actualReturnValue = backpack.deleteItem(Drinks.Type.MILK);
//
//        //THEN
//        StateBackpack actualState = backpack.stateBackpack;
//        StateBackpack expectedState = StateBackpack.EMPTY;
//        Boolean expectedReturnValue = true;
//        ArrayList<Item> actual = backpack.getItems();
//        ArrayList<Item> expected = new ArrayList<>();
//
//        assertEquals(expected, actual);
//        assertEquals(expectedReturnValue, actualReturnValue);
//        assertEquals(expectedState, actualState);
//    }
//
//    @Test
//    public void When_DeleteItemFromBackpack_BackpackContainItemAndReturnFalse() {
//        //GIVEN
//        Mockito.when(item1.getWeight()).thenReturn(10.0);
//        Mockito.when(item1.getName()).thenReturn("MILK");
//        ArrayList<Item> items = backpack.getItems();
//        items.add(item1);
//
//        //WHEN
//        Boolean actualReturnValue = backpack.deleteItem(Drinks.Type.WATER);
//
//        //THEN
//        StateBackpack actualState = backpack.stateBackpack;
//        StateBackpack expectedState = StateBackpack.NOT_FULL;
//        Boolean expectedReturnValue = false;
//        ArrayList<Item> actual = backpack.getItems();
//        ArrayList<Item> expected = new ArrayList<>();
//        expected.add(item1);
//
//        assertEquals(expected, actual);
//        assertEquals(expectedReturnValue, actualReturnValue);
//        assertEquals(expectedState, actualState);
//    }
//
//    @Test
//    public void When_DeleteItemFromEmptyBackpack_DeletingNotHappenAndReturnFalse() {
//        //GIVEN
//
//        //WHEN
//        Boolean actual = backpack.deleteItem(Drinks.Type.MILK);
//
//        //THEN
//        StateBackpack actualState = backpack.stateBackpack;
//        StateBackpack expectedState = StateBackpack.EMPTY;
//        Boolean expected = false;
//        ArrayList<Item> actualList = backpack.getItems();
//        ArrayList<Item> expectedList = new ArrayList<>();
//
//        assertEquals(expectedList, actualList);
//        assertEquals(expected, actual);
//        assertEquals(expectedState, actualState);
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////    @Test
////    public void When_EqualsItemsByContent_ReturnTrue() {
////        //GIVEN
////        Drinks drinks1 = new Drinks(Drinks.Type.MILK, 30, 10, 1);
////        Drinks drinks2 = new Drinks(Drinks.Type.MILK, 30, 10, 1);
////
////        Drinks drinksSpy1 = Mockito.spy(drinks1);
////        Mockito.when(drinksSpy1.getWeight()).thenReturn(4.0);
////        Drinks drinksSpy2 = Mockito.spy(drinks2);
////        Mockito.when(drinksSpy2.getWeight()).thenReturn(4.0);
////        Mockito.when(drinksSpy2.equals(drinksSpy1)).thenReturn(true);
////        backpack.addItem(drinksSpy1);
////        backpack2.addItem(drinksSpy2);
////
////        //WHEN
////        Boolean actual = backpack.equalsByContent(backpack2);
////
////        //THEN
////        Boolean expected = true;
////        assertEquals(expected, actual);
////    }
//
//
//
//
////    @Test
////    public void addItem_whenItemInBackpack_thenItemsSum() {
////        //GIVEN
////        Mockito.when(item1.getWeight()).thenReturn(10.0);
////        Mockito.when(item1.getName()).thenReturn("milk");
////        Mockito.when(item2.getWeight()).thenReturn(5.0);
////        Mockito.when(item2.getName()).thenReturn("milk");
//////        Mockito.when(item1.sumItem(item2)).thenReturn(null);
////        Item mockWorld = Mockito.mock(Item.class);
////        Mockito.doAnswer(new Answer<Void>() {
////            @Override
////            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
////                invocationOnMock.getArgument(0, Item.class);
////                return null;
////            }
////        }).when(item1.sumItem(item2));
////        Mockito.when(item2.getWeight()).w;
//
////        Mockito.doAnswer(new Answer() {
////            private int count = 0;
////
////            public Object answer(InvocationOnMock invocation) {
////                if (count++ == 1)
////                    return 1;
////
////                return 2;
////            }
////        }).when(item1).sumItem(item2);
//
////        item1.sumItem(item2);
////        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
////        System.out.println(item1.getWeight());
////        System.out.println(item2.getWeight());
////
////        //WHEN
////        backpack.addItem(item1);
////        backpack.addItem(item2);
////
////        //THEN
////
////        ArrayList<Item> actual = backpack.getItems();
////        ArrayList<Item> expected = new ArrayList<>();
////        Mockito.when(item1.getWeight()).thenReturn(15.0);
////        expected.add(item1);
//////        assertEquals(expected, actual);
////        assertEquals(actual.get(0).getWeight(), 15.0);
////    }
//
//
////        @Test
////    public void addItem_whenItemInBackpack_thenItemsSum() {
////        //GIVEN
////        Mockito.when(item1.getWeight()).thenReturn(10.0);
////        Mockito.when(item1.getName()).thenReturn("milk");
////        Mockito.when(item2.getWeight()).thenReturn(5.0);
////        Mockito.when(item2.getName()).thenReturn("milk");
//////        Mockito.when(item1.sumItem(item2)).thenReturn(15.0);
////        Item mockWorld = Mockito.mock(Item.class);
////        Item item = new Item() {
////            @Override
////            public void sumItem(Item item) {
////
////            }
////        }
////
////        Mockito.doAnswer(new Item<Void>() {
////           Dummy dummy = mock(Dummy.class);
////              Answer<Integer> answer = new Answer<Integer>() {
////        public Integer answer(InvocationOnMock invocation) throws Throwable {
////            String string = invocation.getArgumentAt(0, String.class);
////            return string.length() * 2;
////        }
////    };
////        }).when(mockWorld).sumItem(item1);
//////        doAnswer {
//////            // invocation on any interaction with setter
//////        }.whenever(instance).property = any()
////        //WHEN
////        backpack.addItem(item1);
////        backpack.addItem(item2);
////
////        //THEN
////
////        ArrayList<Item> actual = backpack.getItems();
////        ArrayList<Item> expected = new ArrayList<>();
////        Mockito.when(item1.getWeight()).thenReturn(15.0);
////        expected.add(item1);
//////        assertEquals(expected, actual);
////        assertEquals(actual.get(0).getWeight(), 15.0);
////    }
//
//
