package travel;

import food.Drinks;
import food.DryRation;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Backpack extends Item implements Collection<Item>{
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

    public double sumWeightItem(String className) {
        return items.stream().filter(item -> item.getClass().getName().equals(className)).mapToDouble(item -> item.weight).sum();
    }

    public Item maxWeightItem() {
        return items.stream()
                .max(Comparator.comparing(item -> item.weight))
                .orElseThrow(NoSuchElementException::new);
    }

    public double averageWeightBackpack() {
        return items.stream().mapToDouble(item -> item.weight).average().orElse(0);
    }


//    public OptionalDouble averageWeightBackpack() {
//        return items.stream().mapToDouble(item -> item.weight).average();
//    }



    public Map<Boolean, List<Item>> partitionEatableItems(Predicate<Item> condition) {
        return items.stream().
                collect(Collectors.partitioningBy(condition));
    }

    //    public Map<Boolean, List<Item>> partitionEatableItems() {
//        return items.stream().
//                collect(Collectors.partitioningBy(item -> item instanceof Dishes));
//    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return items.contains(o);
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    @Override
    public Object[] toArray() {
        return items.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return items.toArray(a);
    }

    @Override
    public boolean add(Item item) {
        return items.add(item);
    }

    @Override
    public boolean remove(Object o) {
        return items.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return items.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Item> c) {
        return items.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return items.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return items.retainAll(c);
    }

    @Override
    public void clear() {
        items.clear();
    }
}




