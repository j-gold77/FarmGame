package interpreter;

public class Feedback {
    public final boolean success;
    public final String message;
    public Feedback(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    // overload ==
    // feedback.equals(feedback)
}