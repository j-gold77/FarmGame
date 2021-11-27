package interpreter;

public class Interpreter {
    public void interpretSentence(String sentence) {
        // Split sentence into words
        String[] words = sentence.toLowerCase().split(" ");
        
        // First word must be "farmer"
        if (!words[0].equals("farmer")) {
            System.out.println("Invalid Sentence: Sentences must start with the word \"Farmer\"");
            return;
        }
        
        
        
    }
}
