package food;

public class Drinks extends Food {

    public enum Type {
        MILK, TEA, COFFEE, CAPPUCCINO, BEER
    }

    public Drinks(Type type, double weight, double volume, double calories) {
        super(weight, volume, calories);
        name = type.toString();
    }


    @Override
    public void eat(double weightToEat) {
        weight = weight - weightToEat;
    }

    @Override
    public String toString() {
        return "Drink: " + name + "," + weight + "," + volume + ".";
    }

    public String toStringForFile() {
        return getClass().getName() + ";" + name + ";" + weight + ";" + volume + ";" + calories + "\n";
    }
}
