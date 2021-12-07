package interpreter;

import display.Display;
import executor.Farmer;
import executor.Level;
import executor.Location;
import executor.animal.Animal;
import executor.animal.Cow;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Interpreter.
 */
public class Interpreter {


    // return prints as strings


    /**
     * Interpret sentence.
     *
     * @param sentence the sentence
     * @param level    the level
     */
    public static void interpretSentence(String sentence, Level level) {
        // Split sentence into words, lowercased and punctuation removed
        String[] tempWords = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        ArrayList<String> words = new ArrayList(Arrays.asList(tempWords));

        // Remove extra words like "the" "of" "is" "going" "to"
        ArrayList<String> uselessWords = new ArrayList(Arrays.asList("the", "the", "of", "is", "to", "a", "in", "towards", "into", "it", "an", "by", "are", "really",
                "very", "still", "with", "their", "his", "its", "him", "hers", "he", "she", "them", "for"));
        for (String s : uselessWords) {
            words.remove(s);
        }

        // Shortest valid sentence is 3 words long.
        if (words.size() < 3) {
            System.out.println("Invalid Sentence: Sentences must be at least 3 meaningful words long!");
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
        ArrayList<String> conditionWords;
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
                	if (words.size() > 4) {
	                    location = level.findLocation(words.get(4));
	                    // See if second argument is a location
	                    if (location != null) {
	                        feedbackProcessor(farmer.move(animal, location), level);
	                    }
	                    else {
	                        System.out.println("Invalid Sentence: The fifth part of the sentence must be the name of a location!");
	                    }
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
                //checks if using the if keyword
            	if (words.size() > 3) {
	                if (words.get(3).equals("if")) {
	                    animal = level.findAnimal(words.get(4));
	                    //if animal doesn't exist, exit to main game
	                    if(animal== null){
	                        System.out.println("invalid sentence. The word after \"if\" must be an animal. Remember code is very specific.");
	                        return;
	                    }
	
	                    conditionWords = new ArrayList(words.subList(4, words.size()));
	                    conditionFeedback = conditionChecker(conditionWords, level);
	                    System.out.println(conditionFeedback.message);
	                    //if the condition checker is a success and the if checker returns true
	                    if (conditionFeedback.success & ifChecker(conditionWords,level)) {
	                        System.out.println(farmer.speak());
	                    }
	                    else
	                        //if the return is false
	                        System.out.println(conditionWords.get(0) + " Is not " + conditionWords.get(1) + ". So farmer john will not speak.");
	                }
            	}
                //if there is if keyword
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
                //checking how long the word is
                if(words.size()>4) {
                    animal = level.findAnimal(words.get(5));
                    //if animal doesn't exist returns to main game
                    if(animal== null) {
                        System.out.println("invalid sentence. The word after \"if\" must be an animal. Remember code is very specific.");
                        return;
                    }

                    //if using the if keyword
                    if (words.get(4).equals("if")) {
                        conditionWords = new ArrayList(words.subList(5, words.size()));
                        conditionFeedback = conditionChecker(conditionWords, level);
                        //condition and if checker only happens when true
                        if (conditionFeedback.success & ifChecker(conditionWords, level)) {
                            animal = level.findAnimal(words.get(3));
                            feedbackProcessor(farmer.nurse(animal), level);
                        }
                        //if false
                        else
                            System.out.println(conditionWords.get(0) + " is not " + conditionWords.get(1) + ". So farmer john will not nurse.");
                    }
                }
                //if not use the keyword if it continues here
                else {
                    // Takes an animal argument, calls farmer.nurse(animal)
                    // Find an animal by its class type
                    animal = level.findAnimal(words.get(3));
                    if (animal != null) {
                        feedbackProcessor(farmer.nurse(animal), level);

                    } else {
                        System.out.println("Invalid Sentence: The third part of the sentence must be the type of an animal that exists! (Pig, Chicken, Cow)");
                    }
                }
                break;
            case "feeds":
            case "feed":
            case "nourish":
            case "nourishes":
                //checking how long the word is
                if(words.size()>4) {
                    animal = level.findAnimal(words.get(5));
                    //if animal doesn't exist returns to main game
                    if(animal== null) {
                        System.out.println("invalid sentence. The word after \"if\" must be an animal. Remember code is very specific.");
                        return;
                    }

                    //if using the if keyword
                    if (words.get(4).equals("if")) {

                        conditionWords = new ArrayList(words.subList(5, words.size()));
                        conditionFeedback = conditionChecker(conditionWords, level);
                        //condition and if checker only happens when true
                        if (conditionFeedback.success & ifChecker(conditionWords, level)) {
                            animal = level.findAnimal(words.get(3));
                            feedbackProcessor(farmer.feed(animal), level);
                        }
                        //if false continues here
                        else
                            System.out.println(conditionWords.get(0) + " is not " + conditionWords.get(1) + ". So farmer john will not feed.");
                    }
                    //checking the while condition
                    else if (words.get(4).equals("while")) {

                        int count = 0;
                        animal = level.findAnimal(words.get(5));
                        //if animal doesn't exist in the second half of the sentence
                        if (animal == null) {
                            System.out.println("invalid sentence. The word after \"if\" must be an animal. Remember code is very specific.");
                        }

                        conditionWords = new ArrayList(words.subList(5, words.size()));
                        conditionFeedback = conditionChecker(conditionWords, level);
                        animal = level.findAnimal(words.get(3));
                        

                        //continues while animal is hungry returns true
                        while (animal.isHungry()) {

                            //condition checker and while condition checker, both must be true
                            if (conditionFeedback.success & whileChecker(conditionWords, level)) {
                                animal = level.findAnimal(words.get(5));
                                Feedback f = (farmer.feed(animal));
                                System.out.println(f.message);
                                count++;
                            }
                            //only happens when both checkers are false
                            else {
                                System.out.println(conditionWords.get(0) + " Is not " + conditionWords.get(1) + ". So farmer john will not feed.");
                                return;
                            }
                        }

                        System.out.println("The animal was very hungry! The animal was fed " + count + " times.");
                        Display.displayStatus(level);
                    }
                }
                //happens when the word is shorter than 5
                else {

                    // Takes an animal argument, calls farmer.feed(animal)
                    // Find an animal by its class type
                    animal = level.findAnimal(words.get(3));
                    if (animal != null) {
                        feedbackProcessor(farmer.feed(animal), level);
                    } else {
                        System.out.println("Invalid Sentence: The third part of the sentence must be the type of an animal that exists! (Pig, Chicken, Cow)");
                    }
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
                //checking how long the word is
                if(words.size()>4) {
                    //checks if the condition is an if statement
                    if (words.get(4).equals("if")) {
                        animal = level.findAnimal(words.get(5));
                        //if animal doesn't exist for the second half of the sentence
                        if(animal== null){
                            System.out.println("invalid sentence. The word after \"if\" must be an animal. Remember code is very specific.");
                            return;
                        }

                        conditionWords = new ArrayList(words.subList(5, words.size()));
                        conditionFeedback = conditionChecker(conditionWords, level);
                        System.out.println(conditionFeedback.message);
                        //condition checker and if statement checker only happens when both are true
                        if (conditionFeedback.success & ifChecker(conditionWords, level)) {
                            animal = level.findAnimal(words.get(3));
                            if (animal == null) {
                                System.out.println("invalid sentence. The word after \"if\" must be an animal. Remember code is very specific.");
                                return;
                            }

                        }
                        //only happens when false
                        else
                            System.out.println(conditionWords.get(0) + " Is not " + conditionWords.get(1) + ". So farmer john will not clean.");
                    }
                }
                //only happens when word is shorter than 5
                else {
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

    /**
     * Feedback processor.
     *
     * @param feedback the feedback
     * @param level    the level
     */
    public static void feedbackProcessor(Feedback feedback, Level level) {
        System.out.println(feedback.message);
        if (feedback.success) {
            Display.displayStatus(level);
        }
    }

    /**
     * Condition checker feedback.
     *
     * @param condition the condition
     * @param level     the level
     * @return the feedback
     */
// Checks if an "if" statement is true
    public static Feedback conditionChecker(ArrayList<String> condition, Level level) {
        // PROCESS SENTENCE INTO CONDITIONS
        return new Feedback(true, "");
    }

    /**
     * If checker boolean.
     *
     * @param sentence the sentence
     * @param level    the level
     * @return the boolean
     */
    public static boolean ifChecker(ArrayList<String> sentence, Level level){

        String animal = sentence.get(0);
        String adjective = sentence.get(1);
       switch(animal){
           case "chicken":
           case "cow":
           case "pig":
               switch (adjective){
                   case "clean":
                       if(level.findAnimal(sentence.get(0)).isClean()){
                           return true;
                       }
                       break;
                   case "hungry":
                       if(level.findAnimal(sentence.get(0)).isHungry()){
                           return true;
                       }
                       break;
                   case "sick":
                       if(level.findAnimal(sentence.get(0)).isSick()){
                           return true;
                       }
                       break;
                   case "filthy":
                       if(!level.findAnimal(sentence.get(0)).clean()){
                           return true;
                       }
                   case "full":
                       if(!level.findAnimal(sentence.get(0)).isHungry()){
                           return true;
                       }
                   case "healthy":
                       if(!level.findAnimal(sentence.get(0)).isSick()){
                           return true;
                       }

               }
               break;
           default:
               System.out.println("Invalid Sentence: After the \"if\" must be an attribute of the animal(clean, filthy, healthy, sick, hungry or full)");
               System.out.println("Also make sure you have the right animal(pig,cow or chicken)");

       }
        return false;
    }

    /**
     * While checker boolean.
     *
     * @param sentence the sentence
     * @param level    the level
     * @return the boolean
     */
    public static boolean whileChecker(ArrayList<String> sentence, Level level) {

        String animal = sentence.get(0);
        String adjective = sentence.get(1);
        switch (animal) {
            case "chicken":
            case "cow":
            case "pig":
                switch (adjective) {
                    case "clean":
                        if (level.findAnimal(sentence.get(0)).isClean()) {
                            return true;
                        }
                        break;
                    case "hungry":
                        if (level.findAnimal(sentence.get(0)).isHungry()) {
                            return true;
                        }
                        break;
                    case "sick":
                        if (level.findAnimal(sentence.get(0)).isSick()) {
                            return true;
                        }
                        break;
                    case "filthy":
                        if (!level.findAnimal(sentence.get(0)).clean()) {
                            return true;
                        }
                    case "full":
                        if (!level.findAnimal(sentence.get(0)).isHungry()) {
                            return true;
                        }
                    case "healthy":
                        if (!level.findAnimal(sentence.get(0)).isSick()) {
                            return true;
                        }

                }
                break;
            default:
                System.out.println("Invalid Sentence: After the \"while\" must be an attribute of the animal(clean, filthy, healthy, sick, hungry or full)");
                System.out.println("Also make sure you have the right animal(pig,cow or chicken)");

        }
        return false;
    }
}