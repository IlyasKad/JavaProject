package medicines;

public class Ointment extends Medicine{
    public enum Type {
        OINTMENTONE, OINTMENTTWO
    }

    public Ointment(Type type, double weight, double volume) {
        super(weight, volume);
        name = type.toString();
    }

    @Override
    public String toString() {
        return "Ointment: " + name + "," + weight + "," + volume + ".";
    }
}
