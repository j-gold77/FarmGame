package executor.animal;

import executor.Location;

public class Chicken extends Animal {

    public Chicken() {
        super();
    }
    
    public Chicken(String name, Location location, int hungry, boolean sick, boolean clean) {
        super(name, location, hungry, sick, clean);
    }

    @Override
    public String speak() {
        return "The chicken clucks!";
    }
    
}
