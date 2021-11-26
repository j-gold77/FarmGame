package executor.location;

import executor.animal.Animal;
import executor.person.Person;
import java.util.ArrayList;

public class Field extends Location {
    
    private ArrayList<Animal> animals;

    public Field() {
        super();
    }
    
    public Field(int filth) {
        super(filth);
    }
    
    public Field(int filth, ArrayList<Person> people, ArrayList<Animal> animals) {
        super(filth, people);
        this.animals = animals;
    }
    
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    
}
