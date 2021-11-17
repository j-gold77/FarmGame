package executor.animal;

import executor.location.Location;

public class Dog extends Animal {
    
    private String color;
    private Location guardedLocation;

    public Dog(String name, Location location, int hungry, boolean sick, boolean clean, String color, Location guardedLocation) {
        super(name, location, hungry, sick, clean);
        this.color = color;
        this.guardedLocation = guardedLocation;
    }

    public String getColor() {
        return color;
    }

    public Location getGuardedLocation() {
        return guardedLocation;
    }

    public void setGuardedLocation(Location guardedLocation) {
        this.guardedLocation = guardedLocation;
    }

    @Override
    public String speak() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
