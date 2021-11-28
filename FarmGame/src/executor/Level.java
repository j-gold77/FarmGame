package executor;

import executor.animal.Animal;
import java.util.ArrayList;

public class Level {

    private ArrayList<Location> locations;
    private ArrayList<Farmer> farmers;
    private ArrayList<Animal> animals;

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public ArrayList<Farmer> getFarmers() {
        return farmers;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    
    public void addLocation(Location location) {
        locations.add(location);
    }
    
    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }
    
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    
    public Location findLocation(String name) {
        Location location = null;
        for (Location l : locations) {
            if (l.getName().equals(name)) {
                location = l;
            }
        }
        return location;
    }
    
    public Farmer findFarmer(String name) {
        Farmer farmer = null;
        for (Farmer f : farmers) {
            if (f.getName().equals(name)) {
                farmer = f;
            }
        }
        return farmer;
    }
    
    public Animal findAnimal(String type) {
        Animal animal = null;
        for (Animal a : animals) {
            if (a.getClass().getSimpleName().equals(type)) {
                animal = a;
            }
        }
        return animal;
    }
}
