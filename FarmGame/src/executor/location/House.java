package executor.location;

import executor.person.Person;
import java.util.ArrayList;

public class House extends Location implements Lockable {
    
    public House() {
        super();
    }
    
    public House(int filth) {
        super(filth);
    }
    
    public House(int filth, ArrayList<Person> people) {
        super(filth, people);
    }
    
}
