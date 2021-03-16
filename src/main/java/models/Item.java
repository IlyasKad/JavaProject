package models;

public class Item {
    public int id;
    public String description;
    public ItemType itemType;
    // public int itemTypeId;
    public double weight;
    public double calories;

    public Item() {
    }

    public Item(String description, ItemType itemType, double weight, double calories) {
        this.id = id;
        this.description = description;
        this.itemType = itemType;
        this.weight = weight;
        this.calories = calories;
    }
}
