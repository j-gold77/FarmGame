package executor.person;

import executor.animal.Animal;
import executor.animal.Sheep;
import executor.location.Barn;
import executor.location.House;
import executor.location.Location;

public class Farmer extends Person {
    
    private boolean tired;

    public Farmer(String name, Location location, boolean tired) {
        super(name, location);
        this.tired = tired;
    }
    
    public boolean getTired() {
        return tired;
    }
    
    public boolean rest(House house) {
        //if (!location.locked()) { return true; }
        return false;
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
    
    // Cleans location and returns whether it succeeded
    public boolean clean(Location location) {
        return location.clean();
    }
    
    // Stocks a barn and returns whether it succeeded
    public boolean stock(Barn barn) {
        return barn.stock();
    }
    
    // Sheers a sheep and returns whether it succeeded
    public boolean sheer(Sheep sheep) {
        return sheep.sheer();
    }
    
}
