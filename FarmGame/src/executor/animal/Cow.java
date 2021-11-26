package executor.animal;

import executor.Location;

public class Cow extends Animal {
    
    private boolean hasMilk;

    public Cow() {
        super();
        this.hasMilk = true;
    }
    
    public Cow(String name, Location location, int hungry, boolean sick, boolean clean, boolean hasMilk) {
        super(name, location, hungry, sick, clean);
        this.hasMilk = hasMilk;
    }
    
    public boolean getHasMilk() {
        return hasMilk;
    }

    public boolean milk() {
        if (hasMilk) {
            this.hasMilk = false;
            return true;
        }
        return false;
    }
    
    @Override
    public String speak() {
        return "The cow moos!";
    }
    
}
