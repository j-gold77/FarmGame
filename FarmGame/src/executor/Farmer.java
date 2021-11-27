package executor;

import executor.animal.Animal;
import executor.animal.Cow;

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
    public boolean move(Location location) {
        if (this.location != location) {
            this.location.getFarmers().remove(this);
            location.getFarmers().add(this);
            this.location = location;
            return true;
        }
        return false;
    }
    
    public String speak() {
        return "Farmer " + name + " sighs...";
    }
    
    // Nurses animal and returns whether it succeeded
    public boolean nurse(Animal animal) {
        if (this.location == animal.getLocation()) {
            return animal.nurse();
        }
        return false;
    }
    
    // Feeds animal and returns whether it succeeded
    public boolean feed(Animal animal) {
        if (this.location == animal.getLocation()) {
            return animal.feed();
        }
        return false;
    }
    
    // Cleans animal and returns whether it succeeded
    public boolean clean(Animal animal) {
        if (this.location == animal.getLocation()) {
            return animal.clean();
        }
        return false;
    }
    
    // Milks the cow and returns whether it succeeded
    public boolean milk(Cow cow) {
        if (this.location == cow.getLocation()) {
            return cow.milk();
        }
        return false;
    }
    
    // Cleans location and returns whether it succeeded
    public boolean clean(Location location) {
        if (this.location == location) {
            return location.clean();
        }
        return false;
    }

    @Override
    public String returnStatus() {
        return "Farmer " + name + " is at the " + location.getName() + ".";
    }

    @Override
    public String returnFeedback() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
