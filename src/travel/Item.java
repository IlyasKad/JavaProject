package travel;

public abstract class Item {
    public double weight;
    public String name;

    public Item(double weight) {
        this.weight = weight;
    }

//    public void sumItem(Item item){
//        this.weight += item.weight;
//    }

    public abstract void sumItem(Item item);

}
