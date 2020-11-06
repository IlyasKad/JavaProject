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

        TravelSet travelSet1 = new TravelSet();

        backpack1.whoCarry = new ArrayList<>(Arrays.asList(tourist1, tourist2));
        backpack1.addTouristWhoCarry(tourist3); // method equals

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
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
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







//        System.out.println("List with iterator: ");
//        Iterator<Item> it = backpack1.getIterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
    }
}




