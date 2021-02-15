package models.pojo;

public class Item {
    private int id;
    private Subcategory subcategory;
    private String name;

    public Item(Subcategory subcategory, String name) {
        this.subcategory = subcategory;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public String getName() {
        return name;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public void setName(String name) {
        this.name = name;
    }
}
