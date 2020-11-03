package travel;

import food.Drinks;
import food.DryRation;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Backpack extends Item{
    private StateBackpack stateBackpack;
    private final ArrayList<Item> items;
    private final double maxWeight;
    private ArrayList<Tourist> whoCarry;

    public Backpack(String name, double weight, double maxWeight) {
        super(weight);
        this.stateBackpack = StateBackpack.EMPTY;
        this.name = name;
        items = new ArrayList<>();
        this.maxWeight = maxWeight;
        whoCarry = new ArrayList<>();
    }

    public StateBackpack getStateBackpack() {
        return stateBackpack;
    }

    public void setStateBackpack(StateBackpack stateBackpack) {
        this.stateBackpack = stateBackpack;
    }

    public Iterator<Item> getIterator() { // итератор
       return items.iterator();
    }

    public ArrayList<Tourist> getWhoCarry() {
        return whoCarry;
    }

    public void setWhoCarry(ArrayList<Tourist> whoCarry) {
        this.whoCarry = whoCarry;
    }

    public void addTouristWhoCarry(Tourist tourist) {
        if (!whoCarry.contains(tourist)) {  // используется неперегруженная версия equals
            whoCarry.add(tourist);
        }
    }

    // best way for my opinion because parameters may be different types (String, int, double)

//    public void add(Drinks.Type type, double weight, double calories, double volume) throws ExceptionLimitOversize {
//        Drinks drinks = new Drinks(type, weight, calories, volume);
//        addItem(drinks);
//    }
//
//    public void add(DryRation.Type name, double weight, double calories) throws ExceptionLimitOversize {
//        DryRation dryRation = new DryRation(name, weight, calories);
//        addItem(dryRation);
//    }
//
//    public void add(Dishes.Type name, double weight) throws ExceptionLimitOversize {
//        Dishes dishes = new Dishes(name, weight);
//        addItem(dishes);
//    }

    public void add(ItemType type, double ... args) throws ExceptionLimitOversize {
        Item item = null;
        if (type.getClass() == Drinks.Type.class) {
            item = new Drinks((Drinks.Type)type, args[0], args[1], args[2]);
        } else if(type.getClass() == DryRation.Type.class) {
            item = new DryRation((DryRation.Type)type, args[0], args[1]);
        } else if(type.getClass() == Dishes.Type.class) {
            item = new Dishes((Dishes.Type)type, args[0]);
        }
//        item = type.getClass().getConstructor(args);
        addItem(item);
    }

    private void addItem(Item item) throws ExceptionLimitOversize {
        if (item == null) {
            return;
        }
        if (this.weight + item.weight > maxWeight ) { // 24 кг + 2 кг > 25 кг
//            throw new ExceptionLimitOversize("Oversize of limit");
            throw new ExceptionLimitOversize(weight, maxWeight);
        }
        Item itemFound = items.stream().filter(tempItem -> tempItem.name.equals(item.name)).findFirst().orElse(null);
        if (itemFound != null) {
            itemFound.sumItem(item);
        } else {
            items.add(item);
        }
        changeState();
    }

    //previous bad version

//    private void addFood(Food food) throws ExceptionLimitOversize {
//        if (this.weight + food.weight > maxWeight ) { // 24 кг + 2 кг > 25 кг
////            throw new ExceptionLimitOversize("Oversize of limit");
//            throw new ExceptionLimitOversize(weight, maxWeight);
//        }
//        Item itemFound = items.stream().filter(item -> item.name.equals(food.name)).findFirst().orElse(null);
//        if (itemFound != null) {
//            Food found = (Food)itemFound;
//            found.weight += food.weight;
//            found.calories += food.calories;
//        } else {
//            items.add(food);
//        }
//        changeState();
//    }

//    public void add(Dishes.Type type, double weight) throws ExceptionLimitOversize {
//        if (this.weight > maxWeight - weight) {
////            throw new ExceptionLimitOversize("Oversize");
//            throw new ExceptionLimitOversize(weight, maxWeight);
//        }
//        Dishes dishes = new Dishes(type, weight);
//        Item found = items.stream().filter(item -> item.name.equals(type.toString())).findFirst().orElse(null);
//
//        if (found != null) {
//            found.weight += weight;
//        } else {
//            items.add(dishes);
//        }
//        changeState();
//    }

    @Override
    public void sumItem(Item item) {
        this.weight += item.weight;
    }

    private void changeState() {
        if (items.size() == 0) {
            stateBackpack = StateBackpack.EMPTY;
        } else if (weight == maxWeight) {
            stateBackpack = StateBackpack.FULL;
        } else {
            stateBackpack = StateBackpack.NOT_FULL;
        }
    }

    public boolean deleteItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            weight -= item.weight;
            return true;
        }
        changeState();
        return false;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List of " + name + " items: \n");
        if (items.size() == 0) {
            return "List of " + name + " is empty\n";
        }
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

    public void openFromFile(String fileName) throws ExceptionLimitOversize {
        BufferedReader objReader = null;
        try {
            String line;
            String[] arr ;
            objReader = new BufferedReader(new FileReader(fileName)); // открывается файл для чтения
            while ((line = objReader.readLine()) != null) {
                arr = line.split(";"); // использование split()
                if (arr[0].equals(food.Drinks.class.getName())) {
                    add(Drinks.Type.valueOf(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));
                } else if (arr[0].equals(food.DryRation.class.getName())) {
                    add(DryRation.Type.valueOf(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]));
                } else if (arr[0].equals(travel.Dishes.class.getName())) {
                    add(Dishes.Type.valueOf(arr[1]), Double.parseDouble(arr[2]));
                }

            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (objReader != null) {
                    objReader.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }


    @Override
    public String toStringForFile() {
        return "";
    }


    public boolean equalsByContent(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Backpack backpack = (Backpack) object;
        if (backpack.items.size() != this.items.size()) {
            return false;
        }
        for (Item i: items) {
            if (!backpack.items.contains(i)) {
                return false;
            }
        }
        for (Item i: backpack.items) {
            if (!items.contains(i)) {
                return false;
            }
        }
        return  true;
    }
}
