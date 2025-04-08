package main.java.chain_of_responsibility.feedback_handler;

public class ContactRequestHandler extends FeedbackHandler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getMessageType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("--------------------------------------");
        System.out.println("Handling Contact Request...");
        System.out.println("From: " + message.getSenderEmail());
        System.out.println("Contact Request: " + message.getContent());
        System.out.println("--------------------------------------\n");
    }
}

