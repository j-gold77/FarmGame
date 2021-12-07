package executor;

import executor.animal.Animal;
import executor.animal.Pig;

import java.util.ArrayList;

/**
 * The type Location.
 */
public class Location implements display.Displayable {

    private String name;
    private int filth;
    private ArrayList<Farmer> farmers;
    private ArrayList<Animal> animals;

    /**
     * Instantiates a new Location.
     */
    public Location() {
        this.filth = 0;
        this.name = "Undefined";
    }

    /**
     * Instantiates a new Location.
     *
     * @param name the name
     */
    public Location(String name) {
        this.name = name;
        this.filth = 0;
        this.farmers = new ArrayList<Farmer>();
        this.animals = new ArrayList<Animal>();
    }

    /**
     * Instantiates a new Location.
     *
     * @param name  the name
     * @param filth the filth
     */
    public Location(String name, int filth) {
        this.name = name;
        this.filth = filth;
        this.farmers = null;
        this.animals = null;
    }

    /**
     * Instantiates a new Location.
     *
     * @param name    the name
     * @param filth   the filth
     * @param farmers the farmers
     * @param animals the animals
     */
    public Location(String name, int filth, ArrayList<Farmer> farmers, ArrayList<Animal> animals) {
        this.name = name;
        this.filth = filth;
        this.farmers = farmers;
        this.animals = animals;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Is clean boolean.
     *
     * @return the boolean
     */
    public boolean isClean() {
        return filth <= 0;
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
     * Add farmer.
     *
     * @param farmer the farmer
     */
    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }

    /**
     * Gets animals.
     *
     * @return the animals
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilth() {
        return filth;
    }

    public void setFilth(int filth) {
        this.filth = filth;
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
     * Clean boolean.
     *
     * @return the boolean
     */
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