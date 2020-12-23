package food;

import travel.Eatable;
import travel.Item;

public abstract class Food extends Item implements Eatable {
    private double calories;

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public Food(double weight, double calories) {
        super(weight);
        this.calories = calories;
    }
}
