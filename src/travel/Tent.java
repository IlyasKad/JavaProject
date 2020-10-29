package travel;

public class Tent extends Item{
    public Tent(double weight, double volume) {
        super(weight, volume);
    }

    @Override
    public String toStringForFile() {
        return null;
    }

    @Override
    public String toString() {
        return "Tent: " + name + ".";
    }
}
