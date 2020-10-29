package food;

public class DryRation extends Food{
    @Override
    public String toStringForFile() {
        return null;
    }

    public enum Type {
        BREAD, ORANGE
    }

    public DryRation(Type type, double weight, double volume, double calories) {
        super(weight, volume, calories);
        name = type.toString();
    }

    @Override
    public void eat(double weightToEat) {
        volume = (weight - weightToEat) * volume / weight;
        weight = weight - weightToEat;
    }

    @Override
    public String toString() {
        return "Dry ration: " + name + "," + weight + "," + volume + ".";
    }
}
