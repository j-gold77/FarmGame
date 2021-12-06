package executor;

import java.util.ArrayList;
import java.util.Scanner;
import executor.animal.Animal;
import executor.animal.Chicken;
import executor.animal.Cow;
import executor.animal.Pig;
import display.Display;
import interpreter.Interpreter;

/**
 * The type Driver.
 */
public class Driver {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // Introduction
        System.out.println("Welcome to the Farm Game!\n"
                + "The purpose of this game is to teach children how to code.\n");

        // Level setup variables
        String premise = "";
        ArrayList<Location> locations = new ArrayList();
        ArrayList<Farmer> farmers = new ArrayList();
        ArrayList<Animal> animals = new ArrayList();

        // Create level
        Level level = new Level(premise, locations, farmers, animals);

        // Level selection
        System.out.println("Select a level by writing its number:");
        System.out.println("Level 1: Teaches the importance of object oriented programming");
        System.out.println("Level 2: Teaches IF conditions with objects");
        System.out.println("Level 3: Teaches while conditions with objects");
        System.out.println("Level 4: Brings together all of what we learned");

        Scanner input = new Scanner(System.in);
        String levelNum = input.nextLine();
        switch(levelNum) {
            case "1":
                level.setPremise("First test level");
                Location barn = new Location("Barn");
                Location farm = new Location("Farm");
                Farmer farmer = new Farmer("John", barn);
                Pig pig = new Pig(barn, 2, true, false);
                Chicken chicken = new Chicken(barn, 1, true, false);
                Cow cow = new Cow(barn, 0, false, true, true);
                level.addLocation(barn);
//                barn.addFarmer(farmer);
//                barn.addAnimal(pig);
//                barn.addAnimal(cow);
//                barn.addAnimal(chicken);
                level.addLocation(farm);
                level.addFarmer(farmer);
                level.addAnimal(pig);
                level.addAnimal(chicken);
                level.addAnimal(cow);
                break;
            case "2":
                level.setPremise("Second test level");
                Location farm2 = new Location("Farm");
                Farmer farmer2 = new Farmer("John", farm2);
                Pig pig2 = new Pig(farm2, 0, true, false);
                Chicken chicken2 = new Chicken(farm2, 0, false, false);
                Cow cow2 = new Cow(farm2, 1, true, true, true);
                level.addLocation(farm2);
                level.addFarmer(farmer2);
                level.addAnimal(pig2);
                level.addAnimal(chicken2);
                level.addAnimal(cow2);
                break;
            case "3":
                level.setPremise("Third test level");
                Location farm3 = new Location("Farm");
                Farmer farmer3 = new Farmer("John", farm3);
                Pig pig3 = new Pig(farm3, 3, true, false);
                Chicken chicken3 = new Chicken(farm3, 3, false, false);
                Cow cow3 = new Cow(farm3, 3, true, true, true);
                level.addLocation(farm3);
                level.addFarmer(farmer3);
                level.addAnimal(pig3);
                level.addAnimal(chicken3);
                level.addAnimal(cow3);
                break;
            case "4":
                break;
            default:
                System.out.println("Your input must be a number that corresponds to the level's index!");
                System.exit(1);
        }

        // Printing the premise
        System.out.println(level.getPremise());

        if(level.getPremise().equals("First test level")){
            Display.displayIntroduction(level);
        }

        // Initial displaying of the level

        Display.displayStatus(level);

        // Input sentences until level is complete (objective met)
        String sentence;
        while(!level.objectiveComplete()) {
            sentence = input.nextLine();
            Interpreter.interpretSentence(sentence, level);
        }

        // Ending message
        System.out.println("Level has been completed!\nRun the program again to select another level...");
    }
}
