package executor.location;

import executor.animal.Animal;
import java.util.ArrayList;

public class Barn extends Location implements Lockable {
    
    private int stock;
    private ArrayList<Animal> animals;

    public Barn(String name, int filth, int stock) {
        super(name, filth);
        this.stock = stock;
    }
    
    public boolean isStocked() {
        return stock >= 5;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    
    // Stock in increments of 1 until stock is at 5, returns whether could stock
    public boolean stock() {
        if (!isStocked()) {
            stock += 1;
            return true;
        }
        return false;
    }
    
}
