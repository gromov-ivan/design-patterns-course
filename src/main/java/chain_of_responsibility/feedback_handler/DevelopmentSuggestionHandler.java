package main.java.chain_of_responsibility.feedback_handler;

public class DevelopmentSuggestionHandler extends FeedbackHandler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getMessageType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("--------------------------------------");
        System.out.println("Handling Development Suggestion...");
        System.out.println("From: " + message.getSenderEmail());
        System.out.println("Suggestion: " + message.getContent());
        System.out.println("--------------------------------------\n");
    }
}
