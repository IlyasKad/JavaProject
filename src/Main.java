
import travel.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        Food milk = new Drinks("milk", 5,100, 1000);
//        Food tea = new Drinks("tea", 2,100, 1000);
//        Food bread = new DryRation("bread", 5,100, 1000);
//        Pill pill = new Pill("pill", 0.1, 1);

        Backpack backpack1 = new Backpack("backpack1", 10, 10, StateBackpack.EMPTY);
        Backpack backpack2 = new Backpack("backpack2", 10, 10, StateBackpack.EMPTY);
//        Tent tent = new Tent("nicolas", 10, 10);

        TravelSet travelSet1 = new TravelSet();

        // add items to travel set
//        backpack1.addItem(milk);
//        backpack1.addItem(Drinks.Type.MILK.toString(), 5,100, 1000);
        backpack1.addDrink(food.Drinks.Type.MILK, 5,100, 1000);
        backpack1.addDrink(food.Drinks.Type.MILK, 5,100, 1000);
        backpack1.addDrink(food.Drinks.Type.CAPPUCCINO, 5,100, 1000);
//        backpack1.addDrink(Drinks.Type.valueOf("MILK"), 5,100, 1000);

//        backpack1.addItem(tea);
//        backpack1.addItem(bread);

        travelSet1.addItem(backpack1);
//        travelSet1.addItem(tent);



//        travelSet1.add('milk', 5, 100, 1000);
//        String requiredItems = "milk,tea,bread";
//        for (String nameItem: requiredItems.split(",")) {
//            System.out.println(nameItem);
//        }

        // eat food and pill
//        bread.eat(2);
//        System.out.println(bread.getWeight());
//        System.out.println(bread.getVolume());
//
//        pill.eat(0.05);
//        System.out.println(pill.getWeight());
//        System.out.println(pill.getVolume());

        System.out.println(backpack1.getStateBackpack());
        System.out.println(backpack1.getStateBackpack().getName());

        System.out.println(travelSet1);
        // remove food from travel set
//        backpack1.deleteItem(bread);
//        System.out.println(travelSet1);
        backpack1.saveToFile("backpack.txt");
        backpack2.openFromFile("backpack.txt");
        System.out.println(backpack2);
    }
}


