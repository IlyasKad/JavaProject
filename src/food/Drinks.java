package food;

public class Drinks extends Food {

    public enum Type {
        MILK, TEA, COFFEE, CAPPUCCINO, BEER
    }

    public Drinks(Type type, double weight, double calories) {
        super(weight, calories);
        name = type.toString();
    }


    @Override
    public void eat(double weightToEat) {
        weight = weight - weightToEat;
    }

    @Override
    public String toString() {
        return "Drink: " + name + "," + weight + "," + calories + ".";
    }

    public String toStringForFile() {
        return getClass().getName() + ";" + name + ";" + weight + ";" + calories + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Drinks drink = (Drinks) object;
        if (drink.name.equals(name) && drink.weight == weight && drink.calories == calories) {
            return  true;
        }
        return false;
    }
}
