package food;

import travel.Item;
import travel.Typeable;

public class Drinks extends Food {
    private final double volume;
    public enum Type implements Typeable {
        MILK, WATER, CAPPUCCINO
    }

    public Drinks(Type type, double weight, double calories, double volume) {
        super(weight, calories);
        setName(type.toString());
        this.volume = volume;
    }

    @Override
    public void eat(double weightToEat) {
        setWeight(getWeight() - weightToEat);
    }

    @Override
    public String toString() {
        return "Drink: " + getName() + "," + getWeight() + "," + getCalories() + "," + volume + ".";
    }

//    public String getWeight2() {
//        return getWeight() + "drinks";
//    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Drinks drink = (Drinks) object;
        if (drink.getName().equals(getName()) && drink.getWeight() == getWeight() && drink.getCalories() == getCalories()) {
            return  true;
        }
        return false;
    }

    @Override
    public void sumItem(Item item) {
        Drinks drinks = (Drinks)item;
        setWeight(this.getWeight() + drinks.getWeight());
        setCalories(this.getCalories() + drinks.getCalories());
    }

//    @Override
//    public static Item sumItem(Item item1, Item item2) {
//        if(item1 instanceof Drinks && item2 instanceof Drinks) {
//            Drinks drinks1 = (Drinks)item1;
//            Drinks drinks2 = (Drinks)item2;
//            drinks1.setWeight(drinks1.getWeight() + drinks2.getWeight());
//            drinks2.setCalories(drinks1.getCalories() + drinks2.getCalories());
//            return drinks1;
//        } else {
//            throw new ClassCastException();
//        }
//        return null;
//    }
}
