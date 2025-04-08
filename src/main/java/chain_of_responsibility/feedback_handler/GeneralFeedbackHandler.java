package main.java.chain_of_responsibility.feedback_handler;

public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getMessageType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("--------------------------------------");
        System.out.println("Handling General Feedback...");
        System.out.println("From: " + message.getSenderEmail());
        System.out.println("Feedback: " + message.getContent());
        System.out.println("--------------------------------------\n");
    }
}

