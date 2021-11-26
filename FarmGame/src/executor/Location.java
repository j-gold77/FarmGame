package executor;

import executor.animal.Animal;
import java.util.ArrayList;

public class Location implements display.Displayable {
    
    private String name;
    private int filth;
    private ArrayList<Farmer> farmers;
    private ArrayList<Animal> animals;

    public Location() {
        this.filth = 0;
        this.name = "Undefined";
    }
    
    public Location(String name) {
        this.name = name;
        this.filth = 0;
    }
    
    public Location(String name, int filth, ArrayList<Farmer> farmers, ArrayList<Animal> animals) {
        this.name = name;
        this.filth = filth;
        this.farmers = farmers;
        this.animals = animals;
    }
    
    public String getName() {
        return name;
    }

    public boolean isClean() {
        return filth <= 0;
    }

    public ArrayList<Farmer> getFarmers() {
        return farmers;
    }
    
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    
    // Clean in decrements of 1 until filth is 0, returns whether could clean
    public boolean clean() {
        if (!isClean()) {
            filth -= 1;
            return true;
        }
        return false;
    }
    
}
