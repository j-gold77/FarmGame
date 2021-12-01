package interpreter;

import display.Display;
import executor.Farmer;
import executor.Level;
import executor.Location;
import executor.animal.Animal;
import executor.animal.Cow;
import java.util.ArrayList;
import java.util.Arrays;

public class Interpreter {

    
    // return prints as strings
    
    
    public static void interpretSentence(String sentence, Level level) {
        // Split sentence into words, lowercased and punctuation removed
        String[] tempWords = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        ArrayList<String> words = new ArrayList(Arrays.asList(tempWords));

        // Remove extra words like "the" "of" "is" "going" "to"
        ArrayList<String> uselessWords = new ArrayList(Arrays.asList("the", "of", "is", "to", "a", "in", "towards", "into", "it", "an", "by", "are", "really",
                "very", "still", "with", "their", "his", "its", "him", "hers", "he", "she", "them", "for"));
        for (String s : uselessWords) {
            words.remove(s);
        }

        // Shortest valid sentence is 3 words long.
        if (words.size() < 3) {
            System.out.println("Invalid Sentence: Sentences must be at least 3 words long!");
            return;
        }

        // First word must be "farmer"
        if (!words.get(0).equals("farmer")) {
            System.out.println("Invalid Sentence: Sentences must start with the word \"Farmer\".");
            return;
        }

        // Find a farmer by their name
        Farmer farmer = level.findFarmer(words.get(1));
        if (farmer == null) {
            System.out.println("Invalid Sentence: The second part of the sentence must be the name of a farmer that exists!");
            return;
        }

        // Action specifier
        // Valid actions: moves, speaks, nurses, cleans, milks
        Feedback actionFeedback;
        Feedback conditionFeedback;
        Animal animal;
        Location location;
        ArrayList<String> condition;
        String action = words.get(2);
        switch (action) {
            case "moves":
            case "move":
            case "take":
            case "takes":
            case "brings":
            case "bring":
            case "guide":
            case "guides":
            case "lead":
            case "leads":
            case "herd":
            case "herds":
                // Takes a location argument only, or an animal and location argument, calls farmer.move(location) or farmer.move(animal, location)
                // Find a location by its name
                location = level.findLocation(words.get(3));
                // Find an animal by its class type
                animal = level.findAnimal(words.get(3));
                // See if argument is a location first
                if (location != null) {
                    feedbackProcessor(farmer.move(location), level);
                } // See if argument is an animal next
                else if (animal != null) {
                    location = level.findLocation(words.get(4));
                    // See if second argument is a location
                    if (location != null) {
                        feedbackProcessor(farmer.move(animal, location), level);
                    }
                    else {
                        System.out.println("Invalid Sentence: The fifth part of the sentence must be the name of a location!");
                    }
                } // Argument is neither
                else {
                    System.out.println("Invalid Sentence: The fourth part of the sentence must be the type of an animal that exists (Pig, Chicken, Cow), or the name of a location!");
                }
                break;
            case "speaks":
            case "talks":
            case "says":
            case "say":
            case "speak":
            case "talk":
                // Takes no arguments, calls farmer.speak()
                if (words.get(3).equals("if")) {
                    condition = new ArrayList(words.subList(4, words.size() - 1));
                    conditionFeedback = conditionChecker(condition, level);
                    System.out.println(conditionFeedback.message);
                    if (conditionFeedback.success) {
                        System.out.println(farmer.speak());
                    }
                }
                else if (words.get(3).equals("while")) {
                    
                }
                else {
                    System.out.println(farmer.speak());
                }
                break;
            case "nurses":
            case "nurse":
            case "heals":
            case "heal":
            case "tend":
            case "tends":
            case "care":
            case "cares":
                // Takes an animal argument, calls farmer.nurse(animal)
                // Find an animal by its class type
                animal = level.findAnimal(words.get(3));
                if (animal != null) {
                    feedbackProcessor(farmer.nurse(animal), level);
                } else {
                    System.out.println("Invalid Sentence: The third part of the sentence must be the type of an animal that exists! (Pig, Chicken, Cow)");
                }
                break;
            case "feeds":
            case "feed":
            case "nourish":
            case "nourishes":
                // Takes an animal argument, calls farmer.feed(animal)
                // Find an animal by its class type
                animal = level.findAnimal(words.get(3));
                if (animal != null) {
                    feedbackProcessor(farmer.feed(animal), level);
                } else {
                    System.out.println("Invalid Sentence: The third part of the sentence must be the type of an animal that exists! (Pig, Chicken, Cow)");
                }
                break;
            case "cleans":
            case "clean":
            case "scrub":
            case "scrubs":
            case "wash":
            case "washes":
            case "rinse":
            case "rinses":
                // Takes an animal or location argument, calls farmer.clean(animal/location)
                // Find an animal by its class type
                animal = level.findAnimal(words.get(3));
                location = level.findLocation(words.get(3));
                // See if argument is an animal first
                if (animal != null) {
                    feedbackProcessor(farmer.clean(animal), level);
                } // See if argument is a location next
                else if (location != null) {
                    feedbackProcessor(farmer.clean(location), level);
                } // Argument is neither
                else {
                    System.out.println("Invalid Sentence: The third part of the sentence must be the type of an animal that exists (Pig, Chicken, Cow), or the name of a location!");
                }
                break;
            case "milks":
            case "milk":
                // Check if argument is Cow
                if (words.get(3).equals("Cow".toLowerCase())) {
                    Cow cow = (Cow) level.findAnimal(words.get(3));
                    feedbackProcessor(farmer.milk(cow), level);
                } else {
                    System.out.println("Invalid Sentence: The fourth part of the sentence must be Cow!");
                }
                break;
            default:
                System.out.println("Invalid Sentence: The third part of the sentence must be an action (moves, speaks, nurses, feeds, cleans, milks)!");
        }
    }

    public static void feedbackProcessor(Feedback feedback, Level level) {
        System.out.println(feedback.message);
        if (feedback.success) {
            Display.displayStatus(level);
        }
    }

    // Checks if an "if" statement is true
    public static Feedback conditionChecker(ArrayList<String> condition, Level level) {
        // PROCESS SENTENCE INTO CONDITIONS
        return new Feedback(true, "");
    }
    
    // WHILE CHECKER?
}
