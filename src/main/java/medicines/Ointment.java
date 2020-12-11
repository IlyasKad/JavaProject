package medicines;

import travel.Item;

public class Ointment extends Medicine{
    public enum Type {
        LEVOMEKOL, KETONAL
    }

    public Ointment(Type type, double weight) {
        super(weight);
        name = type.toString();
    }

    @Override
    public String toString() {
        return "Ointment: " + name + "," + weight + ".";
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
        if (ointment.name.equals(name) && ointment.weight == weight) {
            return  true;
        }
        return false;
    }

    @Override
    public void sumItem(Item item) {
        Ointment ointment = (Ointment)item;
        this.weight += ointment.weight;
    }
}
