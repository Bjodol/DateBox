package core.logic;

/**
 * Created by Bjørn on 30.03.2014.
 */
public enum Other {
    NONE("None"), DIRTY("Dirty");

    private final String value;
    private Other(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
