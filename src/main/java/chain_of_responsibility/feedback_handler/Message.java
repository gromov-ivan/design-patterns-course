package main.java.chain_of_responsibility.feedback_handler;

public class Message {
    private final MessageType messageType;
    private final String content;
    private final String senderEmail;

    public Message(MessageType messageType, String content, String senderEmail) {
        this.messageType = messageType;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getSenderEmail() {
        return senderEmail;
    }
}

