package executor.person;

import executor.location.Location;

public class Visitor extends Person {
    
    private int age;

    public Visitor(String name, Location location, int age) {
        super(name, location);
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String speak() {
        return "Age: " + getAge();
    }
    
}
