package medicines;

import travel.Eatable;
import travel.Item;

public class Pill extends Medicine implements Eatable {
    public enum Type {
        ASPIRIN, LOPERAMIDE
    }
    public Pill(Type type, double weight) {
        super(weight);
        name = type.toString();
    }

    @Override
    public void eat(double weightToEat) {
        weight = weight - weightToEat;
    }

    @Override
    public String toString() {
        return "Pill: " + name + "," + weight + ".";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Pill pill = (Pill) object;
        if (pill.name.equals(name) && pill.weight == weight) {
            return  true;
        }
        return false;
    }

    @Override
    public void sumItem(Item item) {
        Pill pill = (Pill)item;
        this.weight += pill.weight;
    }
}
