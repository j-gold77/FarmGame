package executor;

import java.util.ArrayList;
import java.util.Scanner;

import display.Teaching;
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




        Scanner input = new Scanner(System.in);
        String levelNum = "";

        while (!levelNum.equals("0")) {

            //level selection
            System.out.println("Select a level by writing its number:");
            System.out.println("Level 1: Teaches the importance of object oriented programming");
            System.out.println("Level 2: Teaches IF conditions with objects");
            System.out.println("Level 3: Teaches while conditions with objects");
            System.out.println("Level 4: Brings together all of what we learned");
            System.out.println("Press 0: to exit the game");
            System.out.println("User input: ");
            levelNum = input.nextLine();
            switch (levelNum) {
                case "1":
                    locations.clear();
                    farmers.clear();
                    animals.clear();
                    Level level1 = new Level(premise, locations, farmers, animals);
                    level1.setPremise("First level");
                    Location barn = new Location("Barn");
                    Location farm = new Location("Farm");
                    Farmer farmer = new Farmer("John", barn);
                    Pig pig = new Pig(barn, 2, true, false);
                    Chicken chicken = new Chicken(barn, 1, true, false);
                    Cow cow = new Cow(barn, 0, false, true, true);
                    level1.addLocation(barn);
                    barn.setFarmers(farmer);
                    barn.setAnimals(pig);
                    barn.setAnimals(chicken);
                    barn.setAnimals(cow);
                    level1.addLocation(farm);
                    level1.addFarmer(farmer);
                    level1.addAnimal(pig);
                    level1.addAnimal(chicken);
                    level1.addAnimal(cow);
                    System.out.println(level1.getPremise());
                    Teaching t = new Teaching(level1);
                    String levelPremise = t.getLevelPremise();
                    Display.displayIntroduction(level1);
                    Display.displayStatus(level1);

                    // Input sentences until level is complete (objective met)
                    String sentence ;
                    while (!level1.levelOneObjective()) {
                        System.out.println("User input (type 0 to exit the level): ");
                        sentence = input.nextLine();
                        if (sentence.equals("0")) {
                        	break;
                        }
                        Interpreter.interpretSentence(sentence, level1);
                    }
                    break;
                case "2":
                    locations.clear();
                    farmers.clear();
                    animals.clear();
                    Level level2 = new Level(premise, locations, farmers, animals);
                    level2.setPremise("Second level");
                    Location farm2 = new Location("Farm");
                    Farmer farmer2 = new Farmer("John", farm2);
                    Pig pig2 = new Pig(farm2, 0, true, false);
                    Chicken chicken2 = new Chicken(farm2, 0, false, false);
                    Cow cow2 = new Cow(farm2, 1, true, true, true);
                    level2.addLocation(farm2);
                    level2.addFarmer(farmer2);
                    level2.addAnimal(pig2);
                    level2.addAnimal(chicken2);
                    level2.addAnimal(cow2);
                    farm2.setFarmers(farmer2);
                    farm2.setAnimals(pig2);
                    farm2.setAnimals(chicken2);
                    farm2.setAnimals(cow2);
                    System.out.println(level2.getPremise());
                    Teaching t2 = new Teaching(level2);
                    String levelPremise2 = t2.getLevelPremise();
                    Display.displayIntroduction(level2);
                    Display.displayStatus(level2);

                    // Input sentences until level is complete (objective met)
                    String sentence2;
                    while (!level2.levelTwoObjective()) {
                    	System.out.println("User input (type 0 to exit the level): ");
                        sentence2 = input.nextLine();
                        if (sentence2.equals("0")) {
                        	break;
                        }
                        Interpreter.interpretSentence(sentence2, level2);
                    }
                    break;
                case "3":
                    locations.clear();
                    farmers.clear();
                    animals.clear();
                    Level level3 = new Level(premise, locations, farmers, animals);
                    level3.setPremise("Third level");
                    Location farm3 = new Location("Farm");
                    Farmer farmer3 = new Farmer("John", farm3);
                    Pig pig3 = new Pig(farm3, 0, true, false);
                    Chicken chicken3 = new Chicken(farm3, 3, false, false);
                    Cow cow3 = new Cow(farm3, 3, true, true, true);
                    level3.addLocation(farm3);
                    level3.addFarmer(farmer3);
                    level3.addAnimal(pig3);
                    level3.addAnimal(chicken3);
                    level3.addAnimal(cow3);
                    farm3.setFarmers(farmer3);
                    farm3.setAnimals(pig3);
                    farm3.setAnimals(chicken3);
                    farm3.setAnimals(cow3);
                    System.out.println(level3.getPremise());
                    Teaching t3 = new Teaching(level3);
                    String levelPremise3 = t3.getLevelPremise();
                    Display.displayIntroduction(level3);
                    Display.displayStatus(level3);

                    // Input sentences until level is complete (objective met)
                    String sentence3;
                    while (!level3.levelThreeObjective()) {
                    	System.out.println("User input (type 0 to exit the level): ");
                        sentence3 = input.nextLine();
                        if (sentence3.equals("0")) {
                        	break;
                        }
                        Interpreter.interpretSentence(sentence3, level3);
                    }
                    break;
                case "4":
                    locations.clear();
                    farmers.clear();
                    animals.clear();
                    Level level4 = new Level(premise, locations, farmers, animals);
                    level4.setPremise("Fourth level");
                    Location farm4 = new Location("Farm");
                    Farmer farmer4 = new Farmer("John", farm4);
                    Pig pig4 = new Pig(farm4, 3, true, false);
                    Chicken chicken4 = new Chicken(farm4, 3, false, false);
                    Cow cow4 = new Cow(farm4, 3, true, true, true);
                    farm4.setFarmers(farmer4);
                    farm4.setAnimals(pig4);
                    farm4.setAnimals(chicken4);
                    farm4.setAnimals(cow4);
                    level4.addLocation(farm4);
                    level4.addFarmer(farmer4);
                    level4.addAnimal(pig4);
                    level4.addAnimal(chicken4);
                    level4.addAnimal(cow4);
                    System.out.println(level4.getPremise());
                    Teaching t4 = new Teaching(level4);
                    String levelPremise4 = t4.getLevelPremise();
                    Display.displayIntroduction(level4);
                    Display.displayStatus(level4);

                    // Input sentences until level is complete (objective met)
                    String sentence4;
                    while (true) {
                    	System.out.println("User input (type 0 to exit the level): ");
                        sentence4 = input.nextLine();
                        if (sentence4.equals("0")) {
                        	break;
                        }
                        Interpreter.interpretSentence(sentence4, level4);
                    }
                    break;
                case "0":
                    System.out.println("I hope you enjoyed our game. Have a wonderful day!");
                    break;
                default:
                    System.out.println("Your input must be a number that corresponds to the level's index!");
                    System.exit(1);
            }
        }
    }
}