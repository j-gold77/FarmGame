package executor.animal;

import executor.Location;

public class Cow extends Animal {
    
    private boolean hasMilk;

    public Cow() {
        super();
        this.hasMilk = true;
    }
    
    public Cow(Location location, int hungry, boolean sick, boolean clean, boolean hasMilk) {
        super(location, hungry, sick, clean);
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

    @Override
    public String returnStatus() {
        return "The cow is at the " + getLocation().getName() + ". It is "
                + ((isHungry()) ? "hungry, " : "full, ")
                + ((isSick()) ? "sick, " : "healthy, ")
                + ((isClean()) ? "clean, " : "filthy, ")
                + ((getHasMilk()) ? "and has milk." : "and does not have milk.");
    }

    @Override
    public String returnFeedback() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
