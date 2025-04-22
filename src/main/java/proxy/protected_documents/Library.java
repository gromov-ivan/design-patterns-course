package main.java.proxy.protected_documents;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Library {

    private final Map<String, DocumentResource> docs = new HashMap<>();

    // add a plain, unprotected document
    public void addUnprotected(String id, String content) {
        docs.put(id, new Document(id, content, LocalDateTime.now()));
    }

    // factory for a protected document (+proxy) and its ACL entries
    public void addProtected(String id,
                             String content,
                             Set<String> allowedUsers) {
        Document real = new Document(id, content, LocalDateTime.now());
        // register permissions
        AccessControlService acs = AccessControlService.getInstance();
        allowedUsers.forEach(user -> acs.allow(id, user));
        // store only the proxy in the library
        docs.put(id, new DocumentProxy(real));
    }

    public DocumentResource get(String id) {
        return docs.get(id);
    }
}

