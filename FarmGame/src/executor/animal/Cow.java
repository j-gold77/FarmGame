package executor.animal;

import executor.location.Location;

public class Cow extends Animal {
    
    private boolean hasMilk;

    public Cow(String name, Location location, int hungry, boolean sick, boolean clean, boolean hasMilk) {
        super(name, location, hungry, sick, clean);
        this.hasMilk = hasMilk;
    }
    
    public boolean getHasMilk() {
        return hasMilk;
    }

    @Override
    public String speak() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
