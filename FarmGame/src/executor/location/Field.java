package executor.location;

import executor.animal.Animal;
import java.util.ArrayList;

public class Field extends Location {
    
    private ArrayList<Animal> animals;

    public Field(String name, int filth) {
        super(name, filth);
    }
    
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    
}
