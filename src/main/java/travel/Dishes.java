package travel;

public class Dishes extends Item {
    public enum Type implements Typeable {
        PLATE
    }

    public Dishes(Type type, double weight) {
        super(weight);
        setName(type.toString());
    }

    @Override
    public String toString() {
        return "Dishes: " + getName() + "," + getWeight() + ".";
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
        if (dishes.getName().equals(getName()) && dishes.getWeight() == getWeight()) {
            return  true;
        }
        return false;
    }

    @Override
    public void sumItem(Item item) {
        Dishes dishes = (Dishes) item;
        setWeight(getWeight() + dishes.getWeight());
    }
}
