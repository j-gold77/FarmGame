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

    public void move(Location location) {
        this.location.getFarmers().remove(this);
        location.getFarmers().add(this);
        this.location = location;
    }
    
    public String speak() {
        return "Farmer " + name + " sighs...";
    }
    
    // Nurses animal and returns whether it succeeded
    public boolean nurse(Animal animal) {
        return animal.nurse();
    }
    
    // Feeds animal and returns whether it succeeded
    public boolean feed(Animal animal) {
        return animal.feed();
    }
    
    // Cleans animal and returns whether it succeeded
    public boolean clean(Animal animal) {
        return animal.clean();
    }
    
    // Milks the cow and returns whether it succeeded
    public boolean milk(Cow cow) {
        return cow.milk();
    }
    
    // Cleans location and returns whether it succeeded
    public boolean clean(Location location) {
        return location.clean();
    }

}
