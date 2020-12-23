package travel;

public abstract class Item {
    private double weight;
    private String name;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public Item(double weight) {
        this.weight = weight;
    }

    public abstract void sumItem(Item item);
}
