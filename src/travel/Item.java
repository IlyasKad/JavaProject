package travel;

public abstract class Item {
    protected double weight;
    protected String name;

    public Item(double weight) {
        this.weight = weight;
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
