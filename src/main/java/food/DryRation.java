package food;

import travel.Item;
import travel.Typeable;

public class DryRation extends Food{
    public enum Type implements Typeable {
        BREAD, ORANGE
    }

    public DryRation(Type type, double weight, double calories) {
        super(weight, calories);
        setName(type.toString());
    }

    @Override
    public void eat(double weightToEat) {
        setWeight(getWeight() - weightToEat);
    }

    @Override
    public String toString() {
        return "Dry ration: " + getName() + "," + getWeight() + "," + getCalories() + ".";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        DryRation dryRation = (DryRation) object;
        if (dryRation.getName().equals(getName()) && dryRation.getWeight() == getWeight() && dryRation.getCalories() == getCalories()) {
            return  true;
        }
        return false;
    }

    @Override
    public void sumItem(Item item) {
        DryRation dryRation = (DryRation) item;
        setWeight(this.getWeight() + dryRation.getWeight());
        setCalories( this.getCalories() + dryRation.getCalories());
    }
}
