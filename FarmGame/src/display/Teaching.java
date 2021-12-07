package display;

import executor.Farmer;
import executor.Level;
import executor.Location;
import executor.animal.Animal;

/**
 * The type Teaching.
 */
public class Teaching {


    private Level level;

    /**
     * Instantiates a new Farmer.
     */
    public Teaching() {
        level = null;
    }


    /**
     * Instantiates a new Teaching.
     *
     * @param theLevel the the level
     */
    public Teaching(Level theLevel) {
       level = theLevel;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Get level premise string.
     *
     * @return the string
     */
    public String getLevelPremise(){
        return level.getPremise();
    }


    /**
     * Level introduction.
     */
    public void levelIntroduction(){

        switch(getLevelPremise()){
            case "First level":
                System.out.println("Welcome to the First Level. Get ready to have fun with programming" +
                        " With our amazing barn game!!");
                System.out.println("My name is Farmer John. I will be your guide through out this lesson.");
                System.out.println("During this level we are going to learn all about Object Oriented programming.");
                System.out.println("An Object in programming is a data field that has unique attributes and behaviour.");
                System.out.println("Unlike a simple integer that can only be used in mathematical scenarios," +
                        "you can code your objects to do whatever you wish to accomplish.");
                System.out.println("In this program, we have constructed a farm for you to interact with.");
                System.out.println("The \"Objects\" will be the Farmer, Locations and Animals");
                System.out.println("Your goal for this level is to make sure all the animals objects are clean!");
                rulesLevel1();
                break;
            case "Second level":
                System.out.println("Welcome to the second Level.");
                System.out.println("Here we will begin teaching about conditions statements");
                System.out.println("The first condition statement we will begin using is an IF statement");
                System.out.println("An IF statement can only be executed if the condition given is TRUE");
                System.out.println("IF 4>2 then something will happen.");
                System.out.println("We can use ELSE after the IF statement to execute something else if the conditions is not true");
                System.out.println("In our programs since we are using Objects. We can say IF the pig is clean THEN it moves to the barn");
                System.out.println("If the pig is not clean then the condition will be FALSE and move to the else condition");
                System.out.println("Why don't you give it a try now and try to clean the animals with IF statements");
                rulesLevel2();
                break;
            case "Third level":
                System.out.println("Welcome to the third level.");
                System.out.println("Here we will begin teaching about the second condition statement, the WHILE statement.");
                System.out.println("WHILE functions similar to the IF statement where it will only execute if the statement is true.");
                System.out.println("The fundamental difference is the while condition will keep going until the statement becomes false");
                System.out.println("This can be tricky in programming since you can encounter endless loops if your while statement is always true");
                System.out.println("For this exercise we have made the animals all a certain level of hungry. The conditions statement will be" +
                        "\nwhile (the animal is a hungry) do something.");
                System.out.println("I think we are ready to give this a try.");
                rulesLevel3();
                break;
            case "Fourth level":
                System.out.println("Welcome to the fourth level.");
                System.out.println("Wow we have sure learned a lot today about coding.");
                System.out.println("This level is just an interactive sandbox.");
                System.out.println("you may use any of the statements you have learned from the previous levels.");
                rulesLevel4();


        }
    }

    /**
     * Rules level 1.
     */
    public void rulesLevel1(){
        System.out.println("\n\nBefore we begin I must tell you about some rules to this program.");
        System.out.println("All code follows rules. If you deviate from the rules the code may not run as intended.");
        System.out.println("Rule 1: All sentences must begin with \"Farmer John\".");
        System.out.println("Rule 2: All sentences must be at least 3 meaningful words long.");
        System.out.println("Rule 3: The goal for this level is to clean all animals, But you can feed them, move them and nurse them as much as you want before level ends.");
        System.out.println("Rule 4: Have fun!.");

    }

    /**
     * Rules level 2.
     */
    public void rulesLevel2(){
        System.out.println("\n\nI will now explain some rules for this level.");
        System.out.println("Rule 1: All sentences must begin with \"Farmer John\".");
        System.out.println("Rule 2: All sentences must be at least 3 meaningful words long.");
        System.out.println("Rule 3: After the if keyword you must repeat the animal you are using (ex: farmer john cleans the pig if the pig is clean).");
        System.out.println("Rule 4: The goal for this level is to make sure all the animals are full, clean and healthy with if statements.");
        System.out.println("Rule 5: Have fun!.");
        System.out.println("TIP: Don't forget to milk the cow!");
    }

    /**
     * Rules level 3.
     */
    public void rulesLevel3(){
        System.out.println("\n\nI will now explain some rules for this level.");
        System.out.println("Rule 1: All sentences must begin with \"Farmer John\".");
        System.out.println("Rule 2: All sentences must be at least 3 meaningful words long.");
        System.out.println("Rule 3: After the while keyword you must repeat the animal you are using (ex: farmer john cleans the pig while the pig is clean).");
        System.out.println("Rule 4: The goal for this level is to make sure all the animals are full using while statements.");
        System.out.println("Rule 5: Have fun!.");
    }

    /**
     * Rules level 4.
     */
    public void rulesLevel4(){
        System.out.println("\n\nI will now explain some rules for this level.");
        System.out.println("Rule 1: All sentences must begin with \"Farmer John\".");
        System.out.println("Rule 2: All sentences must be at least 3 meaningful words long.");
        System.out.println("Rule 3: Farmer john cannot interact with the animal until he is in the same location of the animal");
        System.out.println("Rule 4: After the if keyword you must repeat the animal you are using (ex: farmer john cleans the pig if the pig is clean).");
        System.out.println("Rule 5: After the while keyword you must repeat the animal you are using (ex: farmer john cleans the pig while the pig is clean).");
        System.out.println("Rule 6: While statements can only be used to feed the animal.");
        System.out.println("Rule 7: The goal for this level is to make sure all the animals are full using while statements.");
        System.out.println("Rule 8: For this level there is no goal. Just hit 0 when you are finished and you may exit the game.");
        System.out.println("Rule 9: Have fun!.");
    }
}
