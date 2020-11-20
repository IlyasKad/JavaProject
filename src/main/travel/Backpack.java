package travel;

import food.Drinks;
import food.DryRation;

import java.util.ArrayList;
import java.util.Iterator;

public class Backpack extends Item{
    public StateBackpack stateBackpack;
    private final ArrayList<Item> items;
    private final double maxWeight;
    public ArrayList<Tourist> whoCarry;

    public Backpack(String name, double weight, double maxWeight) {
        super(weight);
        this.stateBackpack = StateBackpack.EMPTY;
        this.name = name;
        items = new ArrayList<>();
        this.maxWeight = maxWeight;
        whoCarry = new ArrayList<>();
    }

    public Iterator<Item> getIterator() {
       return items.iterator();
    }

    public void addTouristWhoCarry(Tourist tourist) {
        if (!whoCarry.contains(tourist)) {
            whoCarry.add(tourist);
        }
    }

    public void add(Typeable type, double ... args) throws ExceptionLimitOversize {
        Item item = null;
        if (type.getClass() == Drinks.Type.class) {
            item = new Drinks((Drinks.Type)type, args[0], args[1], args[2]);
        } else if(type.getClass() == DryRation.Type.class) {
            item = new DryRation((DryRation.Type)type, args[0], args[1]);
        } else if(type.getClass() == Dishes.Type.class) {
            item = new Dishes((Dishes.Type)type, args[0]);
        }
        addItem(item);
    }

    private void addItem(Item item) throws ExceptionLimitOversize {
        if (item == null) {
            return;
        }
        if (this.weight + item.weight > maxWeight ) {
            throw new ExceptionLimitOversize(weight, maxWeight);
        }
        weight += item.weight;
        Item itemFound = items.stream().filter(tempItem -> tempItem.name.equals(item.name)).findFirst().orElse(null);
        if (itemFound != null) {
            itemFound.sumItem(item);
        } else {
            items.add(item);
        }
        changeState();
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

    public boolean deleteItem(Typeable type) {
        Item itemFound = items.stream().filter(tempItem -> tempItem.name.equals(type.toString())).findFirst().orElse(null);
        if (itemFound != null) {
            items.remove(itemFound);
            weight -= itemFound.weight;
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

    public void sumItem(Item item){
        Backpack backpack = (Backpack)item;
        for (Item i: backpack.items) {
            addItem(i);
        }
    }
}
