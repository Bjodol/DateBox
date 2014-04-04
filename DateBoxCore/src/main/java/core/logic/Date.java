package core.logic;

/**
 * Created by Bjodol on 28.03.2014.
 */
public class Date {

    private String title, description;
    private Cost cost;
    private Location location;
    private Duration duration;
    private Other other;

    /**
     * Default src.core.models.Date constructor, creates a src.core.models.Date with all values set to null.
     */

    public Date(){
        this.title = null;
        this.description = null;
        this.cost = null;
        this.location = null;
        this.duration = null;
        this.other = null;
    }

    /**
     * src.core.models.Date constructor
     * @param title of date
     * @param description of date
     * @param cost value of date
     * @param location value of date
     * @param duration value of date
     * @param other value of other, can be null.
     */

    public Date(String title, String description, Cost cost, Location location, Duration duration, Other other) {
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.location = location;
        this.duration = duration;
        this.other = other;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }
}