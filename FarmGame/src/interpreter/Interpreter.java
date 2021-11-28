package interpreter;

import executor.Level;
import java.util.ArrayList;
import java.util.Arrays;

public class Interpreter {

    public void interpretSentence(String sentence, Level level) {
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
        if (level.findFarmer(words.get(1)) == null) {
            System.out.println("Invalid Sentence: The second part of the sentence must be the name of a farmer that exists!");
            return;
        }

        // Action specifier
        // Valid actions: moves, speaks, nurses, cleans, milks
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
                //
                break;
            case "speaks":
            case "talks":
            case "says":
            case "say":
            case "speak":
            case "talk":
                //
                break;
            case "nurses":
            case "nurse":
            case "heals":
            case "heal":
            case "tend":
            case "tends":
            case "care":
            case "cares":
                //
                break;
            case "feeds":
            case "feed":
            case "nourish":
            case "nourishes":
                //
                break;
            case "cleans":
            case "clean":
            case "scrub":
            case "scrubs":
            case "wash":
            case "washes":
            case "rinse":
            case "rinses":
                //
                break;
            case "milks":
            case "milk":
                //
                break;
            default:
                System.out.println("Invalid Sentence: The third part of the sentence must be an action (moves, speaks, nurses, feeds, cleans, milks)!");
                return;
        }
    }

    // Checks if an "if" statement is true
    public boolean conditionChecker(String condition, Level level) {
        return false;
    }
}
