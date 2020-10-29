package travel;

public class Dishes extends Item {
    public enum Type {
        PLATE, FORK
    }

    public Dishes(Type type, double weight) {
        super(weight);
        name = type.toString();
    }


    @Override
    public String toString() {
        return "Dishes: " + name + "," + weight + ".";
    }

    public String toStringForFile() {
        return getClass().getName() + ";" + name + ";" + weight + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Dishes dishes = (Dishes) object;
        if (dishes.name.equals(name) && dishes.weight == weight) {
            return  true;
        }
        return false;
    }
}
