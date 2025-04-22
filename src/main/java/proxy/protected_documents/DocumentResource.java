package main.java.proxy.protected_documents;

public interface DocumentResource {
    String getId();
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}

