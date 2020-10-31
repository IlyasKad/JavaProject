package medicines;

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
}
