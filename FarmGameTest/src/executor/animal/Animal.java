package executor.animal;

import executor.Location;

/**
 * The type Animal.
 */
public abstract class Animal implements display.Displayable {

    private Location location;
    private int hungry;
    private boolean sick;
    private boolean clean;

    /**
     * Instantiates a new Animal.
     */
    public Animal() {
        this.location = null;
        this.hungry = 0;
        this.sick = false;
        this.clean = true;
    }

    /**
     * Instantiates a new Animal.
     *
     * @param location the location
     */
    public Animal(Location location) {
        this.location = location;
        location.addAnimal(this);
        this.hungry = 0;
        this.sick = false;
        this.clean = true;
    }

    /**
     * Instantiates a new Animal.
     *
     * @param location the location
     * @param hungry   the hungry
     * @param sick     the sick
     * @param clean    the clean
     */
    public Animal(Location location, int hungry, boolean sick, boolean clean) {
        this.location = location;
        //location.addAnimal(this);
        this.hungry = hungry;
        this.sick = sick;
        this.clean = clean;
    }

    /**
     * Speak string.
     *
     * @return the string
     */
    public abstract String speak();

    /**
     * Move.
     *
     * @param location the location
     */
    public void move(Location location) {
        this.location.getAnimals().remove(this);
        location.addAnimal(this);
        this.location = location;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Is hungry boolean.
     *
     * @return the boolean
     */
    public boolean isHungry() {
        return hungry > 0;
    }

    /**
     * Is sick boolean.
     *
     * @return the boolean
     */
    public boolean isSick() {
        return sick;
    }

    /**
     * Is clean boolean.
     *
     * @return the boolean
     */
    public boolean isClean() {
        return clean;
    }

    /**
     * Feed boolean.
     *
     * @return the boolean
     */
// Returns true if could feed, false if not hungry
    public boolean feed() {
        if (isHungry()) {
            hungry -= 1;
            return true;
        }
        return false;
    }

    /**
     * Nurse boolean.
     *
     * @return the boolean
     */
// Returns true if could nurse, false if not sick in the first place
    public boolean nurse() {
        if (isSick()) {
            this.sick = false;
            return true;
        }
        return false;
    }

    /**
     * Clean boolean.
     *
     * @return the boolean
     */
// Returns true if could clean, false if not unclean in the first place
    public boolean clean() {
        if (!isClean()) {
            this.clean = true;
            return true;
        }
        return false;
    }

    public abstract String picture();


}