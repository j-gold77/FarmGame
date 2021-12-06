package interpreter;

/**
 * The type Feedback.
 */
public class Feedback {
    /**
     * The Success.
     */
    public final boolean success;
    /**
     * The Message.
     */
    public final String message;

    /**
     * Instantiates a new Feedback.
     *
     * @param success the success
     * @param message the message
     */
    public Feedback(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    // overload ==
    // feedback.equals(feedback)
}