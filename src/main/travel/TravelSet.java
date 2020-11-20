package travel;

import java.util.ArrayList;

public class TravelSet {
    public ArrayList<Item> items;

    public TravelSet() {
        this.items = new ArrayList<>();
    }

    public boolean addItem(Item item) {
        if (items.contains(item)) {
            return false;
        }
        items.add(item);
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
        StringBuilder builder = new StringBuilder("List of travel set items: \n");
        for (Item item: items) {
            if (item instanceof Backpack) {
                builder.append(item.toString());
            }
            else {
                builder.append(item).append("\n");
            }
        }
        return builder.toString();
    }
}
