package executor.location;

import executor.person.Person;
import java.util.ArrayList;

public class Location implements display.Displayable {
    
    private String name;
    private int filth;
    private ArrayList<Person> people;

    public Location(String name, int filth) {
        this.name = name;
        this.filth = filth;
    }
    
    public String getName() {
        return name;
    }

    public boolean isClean() {
        return filth <= 0;
    }

    public ArrayList<Person> getPeople() {
        return people;
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
