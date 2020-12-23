package medicines;

import travel.Eatable;
import travel.Item;

public class Pill extends Medicine implements Eatable {
    public enum Type {
        ASPIRIN, LOPERAMIDE
    }

    public Pill(Type type, double weight) {
        super(weight);
        setName(type.toString());
    }

    @Override
    public void eat(double weightToEat) {
        setWeight(getWeight() - weightToEat);
    }

    @Override
    public String toString() {
        return "Pill: " + getName() + "," + getWeight() + ".";
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
        if (pill.getName().equals(getName()) && pill.getWeight() == getWeight()) {
            return  true;
        }
        return false;
    }

    @Override
    public void sumItem(Item item) {
        Pill pill = (Pill)item;
        setWeight(this.getWeight() + pill.getWeight());
    }
}
