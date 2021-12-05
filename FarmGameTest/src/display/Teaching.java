package display;

import executor.Farmer;
import executor.Level;
import executor.Location;
import executor.animal.Animal;
public class Teaching {


    private Level level;

    /**
     * Instantiates a new Farmer.
     */
    public Teaching() {
        level = null;
    }


    public Teaching(Level theLevel) {
       level = theLevel;
    }

    public Level getLevel() {
        return level;
    }

    public String getLevelPremise(){
        return level.getPremise();
    }


    public void levelIntroduction(){

        switch(getLevelPremise()){
            case "First test level":
                System.out.println("Welcome to the First Test Level. Get ready to have fun with programming" +
                        " With our amazing barn game!!");
                System.out.println("My name is Farmer John. I will be your guide through out this lesson.");
                System.out.println("During this level we are going to learn all about Object Oriented programming.");
                System.out.println("An Object in programming is a data field that has unique attributes and behaviour.");
                System.out.println("Unlike a simple integer that can only be used in mathematical scenarios," +
                        "you can code your objects to do whatever you wish to accomplish.");
                System.out.println("In this program, we have constructed a farm for you to interact with.");
                System.out.println("The \"Objects\" will be the Farmer, Locations and Animals");
                System.out.println("Your goal for this level is to make sure all the animals objects are clean!");
                rules();
                break;
            case "Second test level":
                System.out.println("Welcome to the second Test Level.");
                System.out.println("Here we will begin teaching about conditions statements");
                System.out.println("The first condition statement we will begin using is an IF statement");
                System.out.println("An IF statement can only be executed if the condition given is TRUE");
                System.out.println("IF 4>2 then something will happen.");
                System.out.println("We can use ELSE after the IF statement to execute something else if the conditions is not true");
                System.out.println("In our programs since we are using Objects. We can say IF the pig is clean THEN it moves to the barn");
                System.out.println("If the pig is not clean then the condition will be FALSE and move to the else condition");
                System.out.println("Why don't you give it a try now and try to clean the animals with IF statements");
        }
    }

    public void rules(){
        System.out.println("\n\nBefore we begin I must tell you about some rules to this program.");
        System.out.println("All code follows rules. If you deviate from the rules the code may not run as intended.");
        System.out.println("Rule 1: All sentences must begin with the Object \"Farmer John\".");
        System.out.println("Rule 2: All sentences must be at least 3 meaningful words long.");
        System.out.println("Rule 3: The goal for all levels is to clean the animals, But you can feed them, move them and nurse them as much as you want before level ends.");
        System.out.println("Rule 4: Have fun!.");

    }
}
