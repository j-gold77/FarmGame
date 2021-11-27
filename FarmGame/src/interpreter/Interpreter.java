package interpreter;

import executor.Level;

public class Interpreter {
    public void interpretSentence(String sentence, Level level) {
        // Split sentence into words, lowercased and punctuation removed
        String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        
        // Remove extra words like "the" "of" "is" "going" "to"
        // TO DO
        // Maybe conver to arraylist
        
        // Shortest valid sentence is 3 words long.
        if (words.length < 3) {
            System.out.println("Invalid Sentence: Sentences must be at least 3 words long!");
            return;
        }
        
        // First word must be "farmer"
        if (!words[0].equals("farmer")) {
            System.out.println("Invalid Sentence: Sentences must start with the word \"Farmer\".");
            return;
        }
        
        // Find a farmer by their name
        if (level.findFarmer(words[1]) == null) {
            System.out.println("Invalid Sentence: The second word of the sentence must be the name of a farmer that exists!");
            return;
        }
        
        // Action specifier
        // Valid actions: moves, speaks, nurses, cleans, milks
        String action = words[2];
        switch(action) {
            case "moves":
                //
                break;
            case "speaks":
                //
                break;
            case "nurses":
                //
                break;
            case "feeds":
                //
                break;
            case "cleans":
                //
                break;
            case "milks":
                //
                break;
        }
    }
    
    // Checks if an "if" statement is true
    public boolean conditionChecker(String condition, Level level) {
        return false;
    }
}
