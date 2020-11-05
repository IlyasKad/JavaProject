import food.Drinks;
import food.DryRation;
import travel.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Tourist tourist1 = new Tourist("Nick");
        Tourist tourist2 = new Tourist("Nick");
        Tourist tourist3 = new Tourist("Fox");

        Backpack backpack1 = new Backpack("backpack1", 10, 25);
        Backpack backpack2 = new Backpack("backpack2", 10, 25);
        Backpack backpack3 = new Backpack("backpack3", 10, 25);

        TravelSet travelSet1 = new TravelSet();

        backpack1.whoCarry = new ArrayList<>(Arrays.asList(tourist1, tourist2)); // ассоциация

        backpack1.addTouristWhoCarry(tourist3); // неперевизначений метод equals

//        for (StateBackpack value:StateBackpack.values()) {
//            System.out.println(value);
//        }

//        Dishes dishes = new Dishes(Dishes.Type.PLATE, 10);
//        Dishes dishes2 = new Dishes(Dishes.Type.PLATE, 10);
//        dishes.name = null;
//        dishes2.name = null;
//
//        System.out.println( dishes.equals(dishes2));

//        Item item1 = new Item(1) {
//            @Override
//            public String toString() {
//                return super.toString();
//            }
//        };
//        Item item2 = new Item(1) {
//            @Override
//            public String toString() {
//                return super.toString();
//            }
//        };

//        Item item1 = new Item(2);
//        Item item2 = new Item(2);

//        System.out.println(item1.getClass());
//        System.out.println(item2.getClass());
//        System.out.println(item1.equals(item2));

//         add items to backpack1
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
            backpack2.add(Dishes.Type.valueOf("PLATE"),2);

        } catch(Exception e){
            System.out.println(e);
        }

        // add items to backpack3
        try {
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("MILK"), 5, 1000, 1);
            backpack3.add(Drinks.Type.valueOf("CAPPUCCINO"), 1, 1000, 1);
            backpack3.add(Dishes.Type.valueOf("PLATE"),2);

        } catch(Exception e){
            System.out.println(e);
        }


        travelSet1.addItem(backpack1);
        travelSet1.addItem(backpack2);
        travelSet1.addItem(backpack3);


        // eat food and pill
//        bread.eat(2);
//        System.out.println(bread.getWeight());
//        System.out.println(bread.getVolume());
//
//        pill.eat(0.05);
//        System.out.println(pill.getWeight());
//        System.out.println(pill.getVolume());

//        System.out.println(backpack1.getStateBackpack());
//        System.out.println(backpack1.getStateBackpack().getName());

        System.out.println(travelSet1);
        System.out.println();
        // remove food from travel set
//        backpack1.deleteItem(Drinks.Type.MILK);
//        System.out.println(travelSet1);



        // запись в файл и считывание
//        try{
//            backpack1.saveToFile("backpack.txt");
//            backpack2.openFromFile("backpack.txt");
//        } catch(Exception exp){
//            System.out.println(exp);
//
//        }
//        System.out.println(backpack2);
        System.out.println("Equals of backpacks: " + backpack2.equalsByContent(backpack3)); // перевизначений метод equals
//        System.out.println(backpack2.equals(backpack3));

//        System.out.println("List with iterator: ");
//        Iterator<Item> it = backpack1.getIterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

    }
}


