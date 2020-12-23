package travel;

import java.util.ArrayList;

public class TravelSet {
    public ArrayList<Backpack> items;

    public TravelSet() {
        this.items = new ArrayList<>();
    }

    public boolean addItem(Backpack item) {
        if (items.contains(item)) {
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean deleteItem(Backpack item) {
        if (items.contains(item)) {
            items.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List of travel set items: \n");
        for (Backpack item: items) {
            builder.append(item.toString());
        }
        return builder.toString();
    }

    public double sumWeightTravelSet() {
        double sum = 0;
        for (Backpack backpack: items) {
            sum += backpack.getWeight();
        }
        return sum;
    }
}
