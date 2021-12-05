package executor;

import executor.animal.Chicken;
import executor.animal.Cow;
import executor.animal.Pig;

public class DisplayTest {
    public static void main(String[] args) {


        Farmer f = new Farmer();
        System.out.println(f.picture());
    }
}
