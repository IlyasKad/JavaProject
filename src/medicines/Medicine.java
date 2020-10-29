package medicines;

import travel.Item;

public class Medicine extends Item {
    public Medicine(double weight, double volume) {
        super(weight, volume);
    }

    @Override
    public String toStringForFile() {
        return null;
    }


}
