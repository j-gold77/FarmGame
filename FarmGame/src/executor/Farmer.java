package executor;

import executor.animal.Animal;
import executor.animal.Cow;
import interpreter.Feedback;

public class Farmer implements display.Displayable {

    private String name;
    private Location location;

    public Farmer() {
        this.name = "Unnamed";
        this.location = null;
    }

    public Farmer(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    // Moves farmer, returns false if can't move
    public Feedback move(Location location) {
        if (this.location != location) {
            this.location.getFarmers().remove(this);
            location.getFarmers().add(this);
            this.location = location;
            return new Feedback(true, "Farmer" + name + " moved to the " + location.getName() + ".");
        }
        return new Feedback(false, "Source and Target locations are the same, farmer cannot move!");
    }

    // Farmer moves animal, returns false if can't move
    public Feedback move(Animal animal, Location location) {
        if (this.location != location) {
            if (this.location != animal.getLocation()) {
                return new Feedback(true, "Farmer " + name + " moved the " + animal.getClass().getSimpleName() + " to the " + location.getName() + ".");
            }
            return new Feedback(false, "The farmer is not in the same location as the animal, cannot move the animal!");
        }
        return new Feedback(false, "Source and Target locations are the same, farmer cannot move the animal!");
    }

    public String speak() {
        return "Farmer " + name + " sighs...";
    }

    // Nurses animal and returns whether it succeeded
    public Feedback nurse(Animal animal) {
        if (this.location == animal.getLocation()) {
            if (animal.nurse()) {
                return new Feedback(true, "Farmer " + name + " nursed the " + animal.getClass().getSimpleName() + ".");
            }
            return new Feedback(false, "Cannot nurse the " + animal.getClass().getSimpleName() + ", it is already healthy!");
        }
        return new Feedback(false, "Cannot nurse an animal that is not in the same location as the farmer!");
    }

    // Feeds animal and returns whether it succeeded
    public Feedback feed(Animal animal) {
        if (this.location == animal.getLocation()) {
            if (animal.feed()) {
                return new Feedback(true, "Farmer " + name + " fed the " + animal.getClass().getSimpleName() + ".");
            }
            return new Feedback(false, "Cannot feed the " + animal.getClass().getSimpleName() + ", it is already full!");
        }
        return new Feedback(false, "Cannot feed an animal that is not in the same location as the farmer!");
    }

    // Cleans animal and returns whether it succeeded
    public Feedback clean(Animal animal) {
        if (this.location == animal.getLocation()) {
            if (animal.clean()) {
                return new Feedback(true, "Farmer " + name + " cleaned the " + animal.getClass().getSimpleName() + ".");
            }
            return new Feedback(false, "Cannot clean the " + animal.getClass().getSimpleName() + ", it is already clean!");
        }
        return new Feedback(false, "Cannot clean an animal that is not in the same location as the farmer!");
    }

    // Milks the cow and returns whether it succeeded
    public Feedback milk(Cow cow) {
        if (this.location == cow.getLocation()) {
            if (cow.milk()) {
                return new Feedback(true, "Farmer " + name + " milked the cow.");
            }
            return new Feedback(false, "Cannot milk the cow, it does not have any milk left!");
        }
        return new Feedback(false, "Cannot milk a cow that is not in the same location as the farmer!");
    }

    // Cleans location and returns whether it succeeded
    public Feedback clean(Location location) {
        if (this.location == location) {
            if (location.clean()) {
                return new Feedback(true, "Farmer " + name + " clean the " + location.getName() + ".");
            }
            return new Feedback(false, "Cannot clean the " + location.getName() + ", it is already clean!");
        }
        return new Feedback(false, "Cannot clean a location the farmer is not in!");
    }

    @Override
    public String returnStatus() {
        return "Farmer " + name + " is at the " + location.getName() + ".";
    }

}
