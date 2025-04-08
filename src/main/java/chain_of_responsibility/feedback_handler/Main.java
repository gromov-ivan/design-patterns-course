package main.java.chain_of_responsibility.feedback_handler;

public class Main {
    public static void main(String[] args) {
        // Instantiating the handlers
        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactRequestHandler = new ContactRequestHandler();
        FeedbackHandler suggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        // Building the chain
        compensationHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalFeedbackHandler);

        Message message1 = new Message
                (
                        MessageType.CONTACT_REQUEST,
                        "Requesting a contact from your support team.",
                        "alex@gmail.com"
                );
        Message message2 = new Message
                (
                        MessageType.GENERAL_FEEDBACK,
                        "Good service!",
                        "frank@icloud.com"
                );
        Message message3 = new Message
                (
                        MessageType.COMPENSATION_CLAIM,
                        "My order was damaged during shipping.",
                        "charlie@outlook.com");
        Message message4 = new Message
                (
                        MessageType.DEVELOPMENT_SUGGESTION,
                        "Please add more carriers to your service.",
                        "ivan.gromov@metropolia.fi"
                );
        Message message5 = new Message
                (
                        MessageType.GENERAL_FEEDBACK,
                        "I liked your branding.",
                        "i_like_your_brand@gmail.com"
                );

        compensationHandler.handleMessage(message1);
        compensationHandler.handleMessage(message2);
        compensationHandler.handleMessage(message3);
        compensationHandler.handleMessage(message4);
        compensationHandler.handleMessage(message5);
    }
}

