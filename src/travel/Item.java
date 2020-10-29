package travel;

public abstract class Item {
    protected double weight;// TODO
    protected double volume;
    protected String name;

    public Item(double weight, double volume) {
        this.weight = weight;
        this.volume = volume;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Item item = (Item) object;
        return item.name.equals(this.name);
    }

    public abstract String toStringForFile();

}
