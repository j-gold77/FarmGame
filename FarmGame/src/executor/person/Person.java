package executor.person;

import executor.location.Location;

public class Person implements display.Displayable {
    
    private String name;
    private Location location;

    public Person(String name, Location location) {
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
        
    }
    
    public String speak() {
        return "";
    }
    
    // pet
    
    // ride
    
}
