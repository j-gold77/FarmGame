package display;

import executor.Farmer;
import executor.Level;
import executor.Location;
import executor.animal.Animal;

public class Display {

    public static void displayStatus(Level level) {
        System.out.println("---------------------------------");
        if (level.getLocations() != null) {
            for (Location l : level.getLocations()) {
                System.out.println(l.returnStatus());
            }
        }
        if (level.getFarmers() != null) {
            for (Farmer f : level.getFarmers()) {
                System.out.println(f.returnStatus());
            }
        }
        if (level.getAnimals() != null) {
            for (Animal a : level.getAnimals()) {
                System.out.println(a.returnStatus());
            }
        }
        System.out.println("---------------------------------");
    }
}
