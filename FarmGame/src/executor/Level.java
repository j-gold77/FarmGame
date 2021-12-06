package executor;

import executor.animal.Animal;
import executor.animal.Cow;
import java.util.ArrayList;

/**
 * The type Level.
 */
public class Level {

    private String premise;
    private ArrayList<Location> locations;
    private ArrayList<Farmer> farmers;
    private ArrayList<Animal> animals;

    /**
     * Instantiates a new Level.
     *
     * @param premise   the premise
     * @param locations the locations
     * @param farmers   the farmers
     * @param animals   the animals
     */
    public Level(String premise, ArrayList<Location> locations, ArrayList<Farmer> farmers, ArrayList<Animal> animals) {
        this.premise = premise;
        this.locations = locations;
        this.farmers = farmers;
        this.animals = animals;
    }

    /**
     * Gets premise.
     *
     * @return the premise
     */
    public String getPremise() {
        return premise;
    }

    /**
     * Sets premise.
     *
     * @param premise the premise
     */
    public void setPremise(String premise) {
        this.premise = premise;
    }

    /**
     * Gets locations.
     *
     * @return the locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Gets farmers.
     *
     * @return the farmers
     */
    public ArrayList<Farmer> getFarmers() {
        return farmers;
    }

    /**
     * Gets animals.
     *
     * @return the animals
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * Add location.
     *
     * @param location the location
     */
    public void addLocation(Location location) {
        locations.add(location);
    }

    /**
     * Add farmer.
     *
     * @param farmer the farmer
     */
    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }

    /**
     * Add animal.
     *
     * @param animal the animal
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * Find location location.
     *
     * @param name the name
     * @return the location
     */
    public Location findLocation(String name) {
        Location location = null;
        for (Location l : locations) {
            if (l.getName().toLowerCase().equals(name.toLowerCase())) {
                location = l;
            }
        }
        return location;
    }

    /**
     * Find farmer farmer.
     *
     * @param name the name
     * @return the farmer
     */
    public Farmer findFarmer(String name) {
        Farmer farmer = null;
        for (Farmer f : farmers) {
            if (f.getName().toLowerCase().equals(name.toLowerCase())) {
                farmer = f;
            }
        }
        return farmer;
    }

    /**
     * Find animal animal.
     *
     * @param type the type
     * @return the animal
     */
    public Animal findAnimal(String type) {
        Animal animal = null;
        for (Animal a : animals) {
            if (a.getClass().getSimpleName().toLowerCase().equals(type.toLowerCase())) {
                animal = a;
            }
        }
        return animal;
    }

    /**
     * Level one objective boolean.
     *
     * @return the boolean
     */
    public boolean levelOneObjective() {
        if (getAnimals() != null) {
            for (Animal a : animals) {
                if (!a.isClean()) {
                    return false;
                }

            }
        }
        System.out.println("Level has been completed!\n");
        return true;
    }

    public void setFarmers(ArrayList<Farmer> farmers) {
        this.farmers = farmers;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public boolean levelThreeObjective() {
        if (getAnimals() != null) {
            for (Animal a : animals) {
                if (a.isHungry()) {
                    return false;
                }
            }
        }
        System.out.println("Level has been completed!\n");
        return true;
    }

    /**
     * Objective complete boolean.
     *
     * @return the boolean
     */
// Level's objective is complete when all locations are clean and animals are taken care of
    public boolean levelTwoObjective() {
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