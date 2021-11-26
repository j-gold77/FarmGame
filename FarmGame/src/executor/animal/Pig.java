package executor.animal;

import executor.Location;

public class Pig extends Animal {
    
    public Pig() {
        super();
    }

    public Pig(String name, Location location, int hungry, boolean sick, boolean clean) {
        super(name, location, hungry, sick, clean);
    }

    @Override
    public String speak() {
        return "The pig oinks!";
    }
    
}
