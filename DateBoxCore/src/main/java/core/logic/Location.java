package core.logic;

/**
 * Created by Bjørn on 30.03.2014.
 */
public enum Location {
    HOME("Home"), AWAY("Away"), TRIP("Trip");

    private final String value;
    private Location(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
