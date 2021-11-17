package executor.animal;

import executor.location.Location;

public class Horse extends Animal {
    
    private String color;

    public Horse(String name, Location location, int hungry, boolean sick, boolean clean, String color) {
        super(name, location, hungry, sick, clean);
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }

    @Override
    public String speak() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
