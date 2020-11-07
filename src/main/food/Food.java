package food;

import travel.Eatable;
import travel.Item;

public abstract class Food extends Item implements Eatable {
    public double calories;

    public Food(double weight, double calories) {
        super(weight);
        this.calories = calories;
    }
}
