package travel;

public enum StateBackpack {
    EMPTY ("empty"),
    NOT_FULL ("not full"),
    FULL ("full");

    private String name;

    StateBackpack(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "State of backpack is " + name + ".";
    }
}