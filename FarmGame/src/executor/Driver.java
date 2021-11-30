package executor;

import java.util.ArrayList;
import java.util.Scanner;
import executor.animal.Animal;
import executor.animal.Chicken;
import executor.animal.Cow;
import executor.animal.Pig;
import display.Display;
import interpreter.Interpreter;

public class Driver {
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
                //barn.addFarmer(farmer);
                //barn.addAnimal(pig);
                //barn.addAnimal(cow);
                //barn.addAnimal(chicken);
                level.addLocation(farm);
                level.addFarmer(farmer);
                level.addAnimal(pig);
                level.addAnimal(chicken);
                level.addAnimal(cow);
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            default:
                System.out.println("Your input must be a number that corresponds to the level's index!");
                System.exit(1);
        }
        
        // Printing the premise
        System.out.println(level.getPremise());
        
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
