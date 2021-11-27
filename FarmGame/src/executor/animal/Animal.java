package executor.animal;

import executor.Location;

public abstract class Animal implements display.Displayable {
    
    private Location location;
    private int hungry;
    private boolean sick;
    private boolean clean;

    public Animal() {
        this.location = null;
        this.hungry = 0;
        this.sick = false;
        this.clean = true;
    }
    
    public Animal(Location location, int hungry, boolean sick, boolean clean) {
        this.location = location;
        this.hungry = hungry;
        this.sick = sick;
        this.clean = clean;
    }
    
    public abstract String speak();
    
    public void move(Location location) {
        this.location.getAnimals().remove(this);
        location.getAnimals().add(this);
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isHungry() {
        return hungry >= 0;
    }

    public boolean isSick() {
        return sick;
    }

    public boolean isClean() {
        return clean;
    }

    // Returns true if could feed, false if not hungry
    public boolean feed() {
        if (isHungry()) {
            hungry -= 1;
            return true;
        }
        return false;
    }

    // Returns true if could nurse, false if not sick in the first place
    public boolean nurse() {
        if (sick) {
            this.sick = false;
            return true;
        }
        return false;
    }

    // Returns true if could clean, false if not unclean in the first place
    public boolean clean() {
        if (sick) {
            this.sick = false;
            return true;
        }
        return false;
    }
    
}
