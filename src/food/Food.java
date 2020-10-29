package food;

import travel.Eatable;
import travel.Item;

public abstract class Food extends Item implements Eatable {
    public double calories;

    public Food(double weight, double volume, double calories) {
        super(weight, volume);
        this.calories = calories;
    }
}
