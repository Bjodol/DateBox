package core.logic;

/**
 * Created by Bjørn on 30.03.2014.
 */
public enum Cost {
    FREE("Free"), CHEAP("Cheap"), MEDIUM("Medium"), EXPENSIVE("Expensive");

    private final String value;
    private Cost(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
