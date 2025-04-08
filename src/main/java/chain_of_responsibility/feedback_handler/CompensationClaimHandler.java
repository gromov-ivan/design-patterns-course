package main.java.chain_of_responsibility.feedback_handler;

public class CompensationClaimHandler extends FeedbackHandler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getMessageType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("--------------------------------------");
        System.out.println("Handling Compensation Claim...");
        System.out.println("From: " + message.getSenderEmail());
        System.out.println("Claim: " + message.getContent());
        System.out.println("--------------------------------------\n");
    }
}

