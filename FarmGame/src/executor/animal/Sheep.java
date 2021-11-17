package executor.animal;

import executor.location.Location;

public class Sheep extends Animal {
    
    private boolean thickWool;

    public Sheep(String name, Location location, int hungry, boolean sick, boolean clean, boolean thickWool) {
        super(name, location, hungry, sick, clean);
        this.thickWool = thickWool;
    }
    
    public boolean getThickWool() {
        return thickWool;
    }
    
    // Sheer returns true if sheep had thick wool, otherwise false if it couldn't
    public boolean sheer() {
        if (thickWool) {
            thickWool = false;
            return true;
        }
        return false;
    }

    @Override
    public String speak() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
