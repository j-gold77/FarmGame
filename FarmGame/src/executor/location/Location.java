package executor.location;

import executor.person.Person;
import java.util.ArrayList;

public class Location implements display.Displayable {
    
    private int filth;
    private ArrayList<Person> people;

    public Location() {
        this.filth = 0;
    }
    
    public Location(int filth) {
        this.filth = filth;
    }
    
    public Location(int filth, ArrayList<Person> people) {
        this.filth = filth;
        this.people = people;
    }
    
    // Return classe name i.e barn, field, house
    public String getName() {
        return this.getClass().getSimpleName();
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
