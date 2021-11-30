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
    
    public Location(String name, int filth) {
        this.name = name;
        this.filth = filth;
        this.farmers = null;
        this.animals = null;
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

    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }
    
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Clean in decrements of 1 until filth is 0, returns whether could clean
    public boolean clean() {
        if (!isClean()) {
            filth -= 1;
            return true;
        }
        return false;
    }

    @Override
    public String returnStatus() {
        return "The " + name + " is " + ((isClean()) ? "clean." : "filthy.");
    }

}
