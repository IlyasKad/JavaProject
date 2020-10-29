package travel;

import food.Drinks;

import java.io.*;
import java.util.ArrayList;

public class Backpack extends Item{
    private StateBackpack stateBackpack;
    private final ArrayList<Item> items;

    public Backpack(String name, double weight, double volume, StateBackpack stateBackpack) {
        super(weight, volume);
        this.stateBackpack = stateBackpack;
        this.name = name;
        items = new ArrayList<>();
    }

    public StateBackpack getStateBackpack() {
        return stateBackpack;
    }

    public void setStateBackpack(StateBackpack stateBackpack) {
        this.stateBackpack = stateBackpack;
    }

    public boolean addItem(Item item) {
        if (items.contains(item)) {
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean addDrink(Drinks.Type name, double weight, double volume, double calories) {
        Drinks drinks = new Drinks(name, weight, volume, calories);
        if (items.contains(drinks)) {
            return false;
        }
        items.add(drinks);
        return true;
    }

    public boolean deleteItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List of " + name + " items: \n");
        for (Item item: items) {
            builder.append("\t" + item).append("\n");
        }
        return builder.toString();
    }

    public void saveToFile(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Item item: items) {
            writer.write(item.toStringForFile());
        }
        writer.close();
    }

    public void openFromFile(String fileName) throws IOException {
        BufferedReader objReader = null;
        try {
            String line;
            String[] arr ;
            objReader = new BufferedReader(new FileReader(fileName));
            while ((line = objReader.readLine()) != null) {
                arr = line.split(";");
                if (arr[0].equals("food.Drinks")) {
                    addDrink(Drinks.Type.valueOf(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Double.parseDouble(arr[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null) {
                    objReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


    @Override
    public String toStringForFile() {
        return null;
    }
}
