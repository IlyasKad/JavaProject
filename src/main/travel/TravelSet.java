package travel;

import java.util.ArrayList;
import java.util.Collection;

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
        return items.stream()
                .flatMap(Collection::stream).mapToDouble(item -> item.weight).sum();
    }
}
