package medicines;

import travel.Item;

public class Ointment extends Medicine{
    public enum Type {
        LEVOMEKOL, KETONAL
    }

    public Ointment(Type type, double weight) {
        super(weight);
        setName(type.toString());
    }

    @Override
    public String toString() {
        return "Ointment: " + getName() + "," + getWeight() + ".";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Ointment ointment = (Ointment) object;
        if (ointment.getName().equals(getName()) && ointment.getWeight() == getWeight()) {
            return  true;
        }
        return false;
    }

    @Override
    public void sumItem(Item item) {
        Ointment ointment = (Ointment)item;
        setWeight(this.getWeight() + ointment.getWeight());
    }
}
