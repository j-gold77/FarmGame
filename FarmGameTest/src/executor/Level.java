package executor;

import executor.animal.Animal;
import executor.animal.Cow;
import java.util.ArrayList;

public class Level {

    private String premise;
    private ArrayList<Location> locations;
    private ArrayList<Farmer> farmers;
    private ArrayList<Animal> animals;

    public Level(String premise, ArrayList<Location> locations, ArrayList<Farmer> farmers, ArrayList<Animal> animals) {
        this.premise = premise;
        this.locations = locations;
        this.farmers = farmers;
        this.animals = animals;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

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
            if (l.getName().toLowerCase().equals(name.toLowerCase())) {
                location = l;
            }
        }
        return location;
    }

    public Farmer findFarmer(String name) {
        Farmer farmer = null;
        for (Farmer f : farmers) {
            if (f.getName().toLowerCase().equals(name.toLowerCase())) {
                farmer = f;
            }
        }
        return farmer;
    }

    public Animal findAnimal(String type) {
        Animal animal = null;
        for (Animal a : animals) {
            if (a.getClass().getSimpleName().toLowerCase().equals(type.toLowerCase())) {
                animal = a;
            }
        }
        return animal;
    }

    // Level's objective is complete when all locations are clean and animals are taken care of
    public boolean objectiveComplete() {
        // Objective incomplete if any location is filthy
        if (getLocations() != null) {
            for (Location l : locations) {
                if (!l.isClean()) {
                    return false;
                }
            }
        }

        // Objective incomplete if any animal is sick, hungry, or filthy
        if (getAnimals() != null) {
            for (Animal a : animals) {
                if (a.isSick() || a.isHungry() || !a.isClean()) {
                    return false;
                }
                // Check if a cow still has milk
                if (a instanceof Cow) {
                    if (((Cow) a).getHasMilk()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}