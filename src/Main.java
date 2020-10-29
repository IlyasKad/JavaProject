import food.Drinks;
import food.DryRation;
import travel.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Backpack backpack1 = new Backpack("backpack1", 10, 25);
        Backpack backpack2 = new Backpack("backpack2", 10, 25);
        Backpack backpack3 = new Backpack("backpack3", 10, 25);

        TravelSet travelSet1 = new TravelSet();

        // add items to travel set
        try {
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000);
            backpack1.add(Drinks.Type.valueOf("MILK"), 5, 1000);
            backpack1.add(Drinks.Type.valueOf("CAPPUCCINO"), 5, 1000);
            backpack1.add(Dishes.Type.valueOf("PLATE"),5);
            backpack1.add(DryRation.Type.valueOf("BREAD"), 5, 1000);
        } catch(Exception e){
            System.out.println(e);
        }


        try {
            backpack3.add(food.Drinks.Type.CAPPUCCINO, 5, 1000);
            backpack3.add(food.Drinks.Type.MILK, 5, 1000);
            backpack3.add(food.Drinks.Type.MILK, 5, 1000);
            backpack3.add(Dishes.Type.valueOf("PLATE"), 5);
            backpack3.add(DryRation.Type.valueOf("BREAD"), 5, 1000);
        }
        catch(Exception e){
            System.out.println(e);
        }


        travelSet1.addItem(backpack1);


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




        try{
            backpack1.saveToFile("backpack.txt");
            backpack2.openFromFile("backpack.txt");
        } catch(Exception exp){
            System.out.println(exp);
        }
        System.out.println(backpack3);
        System.out.println(backpack1.equals(backpack2));;


        Iterator it = backpack1.getIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}


