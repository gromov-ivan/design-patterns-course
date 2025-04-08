package main.java.chain_of_responsibility.feedback_handler;

public abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    // Link to the next handler
    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // The main method to handle a message
    public void handleMessage(Message message) {
        if (canHandle(message)) {
            processMessage(message);
        } else if (nextHandler != null) {
            nextHandler.handleMessage(message);
        } else {
            System.out.println("No handler available for: " + message.getMessageType());
        }
    }

    // Each concrete handler decides if it can handle this message type
    protected abstract boolean canHandle(Message message);

    // If it can handle, perform the logic
    protected abstract void processMessage(Message message);
}

