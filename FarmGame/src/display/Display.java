package display;

import executor.Farmer;
import executor.Level;
import executor.Location;
import executor.animal.Animal;

public class Display {
    public void displayStatus(Level level) {
        for (Location l : level.getLocations()) {
            System.out.println(l.returnStatus());
        }
        for (Farmer f : level.getFarmers()) {
            System.out.println(f.returnStatus());
        }
        for (Animal a : level.getAnimals()) {
            System.out.println(a.returnStatus());
        }
    }
}
