package executor;

import executor.animal.Animal;
import executor.animal.Cow;
import interpreter.Feedback;

/**
 * The type Farmer.
 */
public class Farmer implements display.Displayable {

    private String name;
    private Location location;

    /**
     * Instantiates a new Farmer.
     */
    public Farmer() {
        this.name = "Unnamed";
        this.location = null;
    }

    /**
     * Instantiates a new Farmer.
     *
     * @param name the name
     */
    public Farmer(String name) {
        this.name = name;
        this.location = null;
    }

    /**
     * Instantiates a new Farmer.
     *
     * @param name     the name
     * @param location the location
     */
    public Farmer(String name, Location location) {
        this.name = name;
        this.location = location;
        //location.addFarmer(this);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
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
     * Move feedback.
     *
     * @param location the location
     * @return the feedback
     */
// Moves farmer, returns false if can't move
    public Feedback move(Location location) {
        if (this.location != location) {
            this.location.getFarmers().remove(this);
            location.addFarmer(this);
            this.location = location;
            return new Feedback(true, "Farmer" + name + " moved to the " + location.getName() + ".");
        }
        return new Feedback(false, "Source and Target locations are the same, farmer cannot move!");
    }

    /**
     * Move feedback.
     *
     * @param animal   the animal
     * @param location the location
     * @return the feedback
     */
// Farmer moves animal, returns false if can't move
    public Feedback move(Animal animal, Location location) {
        if (this.location == animal.getLocation()) {
            animal.setLocation(location);
            return new Feedback(true, "Farmer " + name + " moved the " + animal.getClass().getSimpleName() + " to the " + location.getName() + "."+ "\n" + animal.picture());
        }
        return new Feedback(false, "The farmer is not in the same location as the animal, cannot move the animal!");

    }

    /**
     * Speak string.
     *
     * @return the string
     */
    public String speak() {
        return "Farmer " + name + " sighs...";
    }

    /**
     * Nurse feedback.
     *
     * @param animal the animal
     * @return the feedback
     */
// Nurses animal and returns whether it succeeded
    public Feedback nurse(Animal animal) {
        if (this.location == animal.getLocation()) {
            if (animal.nurse()) {
                return new Feedback(true, "Farmer " + name + " nursed the " + animal.getClass().getSimpleName() + "."+ "\n" + animal.picture());
            }
            return new Feedback(false, "Cannot nurse the " + animal.getClass().getSimpleName() + ", it is already healthy!");
        }
        return new Feedback(false, "Cannot nurse an animal that is not in the same location as the farmer!");
    }

    /**
     * Feed feedback.
     *
     * @param animal the animal
     * @return the feedback
     */
// Feeds animal and returns whether it succeeded
    public Feedback feed(Animal animal) {
        if (this.location == animal.getLocation()) {
            if (animal.feed()) {
                return new Feedback(true, "Farmer " + name + " fed the " + animal.getClass().getSimpleName() + ".\nThe " + animal.getClass().getSimpleName() + " is "
                        + ((animal.isHungry()) ? "not full yet!" : "now completely full!")+ "\n" + animal.picture());
            }
            return new Feedback(false, "Cannot feed the " + animal.getClass().getSimpleName() + ", it is already full!");
        }
        return new Feedback(false, "Cannot feed an animal that is not in the same location as the farmer!");
    }

    /**
     * Clean feedback.
     *
     * @param animal the animal
     * @return the feedback
     */
// Cleans animal and returns whether it succeeded
    public Feedback clean(Animal animal) {
        if (this.location == animal.getLocation()) {
            if (animal.clean()) {
                return new Feedback(true, "Farmer " + name + " cleaned the " + animal.getClass().getSimpleName() + "\n" + animal.picture());
            }
            return new Feedback(false, "Cannot clean the " + animal.getClass().getSimpleName() + ", it is already clean!");
        }
        return new Feedback(false, "Cannot clean an animal that is not in the same location as the farmer!");
    }

    /**
     * Milk feedback.
     *
     * @param cow the cow
     * @return the feedback
     */
// Milks the cow and returns whether it succeeded
    public Feedback milk(Cow cow) {
        if (this.location == cow.getLocation()) {
            if (cow.milk()) {
                return new Feedback(true, "Farmer " + name + " milked the cow." + cow.picture());
            }
            return new Feedback(false, "Cannot milk the cow, it does not have any milk left!");
        }
        return new Feedback(false, "Cannot milk a cow that is not in the same location as the farmer!");
    }

    /**
     * Clean feedback.
     *
     * @param location the location
     * @return the feedback
     */
// Cleans location and returns whether it succeeded
    public Feedback clean(Location location) {
        if (this.location == location) {
            if (location.clean()) {
                return new Feedback(true, "Farmer " + name + " clean the " + location.getName() + ".\nThe " + location.getName() + " is "
                        + ((location.isClean()) ? "now completely clean!" : "not clean enough yet!"));
            }
            return new Feedback(false, "Cannot clean the " + location.getName() + ", it is already clean!");
        }
        return new Feedback(false, "Cannot clean a location the farmer is not in!");
    }

    @Override
    public String returnStatus() {
        return "Farmer " + name + " is at the " + location.getName() + ".";
    }
    public String picture(){
        return "    .------\\ /------." +
                "\n    |       -       |" +
                "\n    |               |" +
                "\n    |               |" +
                "\n _______________________" +
                "\n ===========.===========" +
                "\n   / ~~~~~     ~~~~~ \\" +
                "\n  /|     |     |      \\" +
                "\n  W   ---  / \\  ---   W" +
                "\n  \\.      |o o|      ./" +
                "\n   |                 |" +
                "\n   \\    #########    /" +
                "\n    \\  ## ----- ##  /" +
                "\n     \\##         ##/" +
                "\n      \\_____v_____/" ;
    }
}