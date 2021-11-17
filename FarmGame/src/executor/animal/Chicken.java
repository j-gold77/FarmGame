package executor.animal;

import executor.location.Location;

public class Chicken extends Animal {
    
    private String size;

    public Chicken(String name, Location location, int hungry, boolean sick, boolean clean, String size) {
        super(name, location, hungry, sick, clean);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String speak() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
