import food.Drinks;
import travel.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tourist tourist1 = new Tourist("Nick");
        Tourist tourist2 = new Tourist("Nick");
        Tourist tourist3 = new Tourist("Fox");

        Backpack backpack1 = new Backpack("backpack1", 10, 25);
        Backpack backpack2 = new Backpack("backpack2", 10, 25);
        Backpack backpack3 = new Backpack("backpack3", 10, 25);

//        System.out.println(backpack3.averageWeightBackpack());
//        backpack3.averageWeightBackpack().ifPresent(value -> System.out.println(value));
        TravelSet travelSet1 = new TravelSet();

        backpack1.whoCarry = new ArrayList<>(Arrays.asList(tourist1, tourist2));
        backpack1.addTouristWhoCarry(tourist3);

        try {
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack1.add(Drinks.Type.valueOf("WATER"), 1, 0, 1);
        } catch(Exception e){
            System.out.println(e);
        }

        try {
            backpack2.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack2.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack2.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
            backpack2.add(Dishes.Type.valueOf("PLATE"),3);
        } catch(Exception e){
            System.out.println(e);
        }

        try {
            backpack3.add(Drinks.Type.valueOf("CAPPUCCINO"), 6, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("MILK"), 3, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("MILK"), 3, 1000, 1);
            backpack3.add(Dishes.Type.valueOf("PLATE"),2);
//            backpack3.add(Drinks.Type.valueOf("WATER"), 1, 1000, 1);
        } catch(Exception e){
            System.out.println(e);
        }

        travelSet1.addItem(backpack1);
        travelSet1.addItem(backpack2);
        travelSet1.addItem(backpack3);

        System.out.println(travelSet1);
        System.out.println();

        System.out.println("Equals of backpacks: " + backpack2.equalsByContent(backpack3));


        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(backpack3.sumWeightItem("travel.Dishes")); // 1

        System.out.println(backpack1.maxWeightItem());// 2

        System.out.println(backpack3.averageWeightBackpack()); // 3

        System.out.println(backpack3.partitionEatableItems(item -> item instanceof Eatable)); // 4 v1
//        System.out.println(backpack3.partitionEatableItems()); // 4 v2


        System.out.println(travelSet1.sumWeightTravelSet());


//        Item item1 = new Drinks(Drinks.Type.valueOf("CAPPUCCINO"), 15, 1000, 1);
//        Item item2 = new Drinks(Drinks.Type.valueOf("CAPPUCCINO"), 10, 1070, 1);
//        System.out.println();
//        Comparator comparator = Comparator.comparing((Drinks item) -> item.calories);
//        System.out.println(comparator.compare(item1, item2));



        /////////////////////////////////
//        Predicate<ArrayList<Integer>> isPositive = x -> x.get(0) > x.get(1);
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        System.out.println(isPositive.test(list)); // true

//        BiPredicate<Integer, Integer> isPositive = (x, y) -> x > y;
//        System.out.println(isPositive.test(1, 2)); // true



//        BiPredicate<Integer, Integer> isEqual = (x, y) -> {
//
//                save("hdhdh.txt");
//
//            return false;
//        };
//        System.out.println(isEqual.test(0, 0));




    }
//    public static void save(String filename) throws IOException {
//
//    }

}




