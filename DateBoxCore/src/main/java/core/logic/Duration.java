package core.logic;

/**
 * Created by Bjørn on 30.03.2014.
 */
public enum Duration {
    SHORT("Short"), NORMAL("Normal"), LONG("Long");

    private final String value;
    private Duration(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
