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
            backpack1.add(Dishes.Type.valueOf("PLATE"), 1);
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


        System.out.println("=======================");

        System.out.println(backpack3.sumWeightItem("travel.Dishes"));

        System.out.println(backpack3.maxWeightItem());

        System.out.println(backpack3.averageWeightBackpack());

        System.out.println(backpack1.partitionEatableItems(item -> item instanceof Eatable)); // v1
//        System.out.println(backpack3.partitionEatableItems()); // v2


        System.out.println(travelSet1.sumWeightTravelSet());


//        Item item1 = new Drinks(Drinks.Type.valueOf("CAPPUCCINO"), 15, 1000, 1);
//        Item item2 = new Drinks(Drinks.Type.valueOf("CAPPUCCINO"), 10, 1070, 1);
//        System.out.println();
//        Comparator comparator = Comparator.comparing((Drinks item) -> item.calories);
//        System.out.println(comparator.compare(item1, item2));

    }
}




