package main.java.proxy.protected_documents;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Document implements DocumentResource {

    private final String id;
    private final String content;
    private final String creationDate;

    Document(String id, String content, LocalDateTime created) {
        this.id = id;
        this.content = content;
        this.creationDate = created.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
