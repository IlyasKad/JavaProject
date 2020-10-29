package travel;

public class Tent extends Item{
    public Tent(double weight) {
        super(weight);
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
