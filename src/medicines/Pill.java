package medicines;

import travel.Eatable;

public class Pill extends Medicine implements Eatable {
    public enum Type {
        ASPIRIN, NOSHPA
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


}
