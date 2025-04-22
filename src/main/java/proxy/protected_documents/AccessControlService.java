package main.java.proxy.protected_documents;

import java.util.*;

class AccessControlService {

    private static final AccessControlService INSTANCE = new AccessControlService();
    private final Map<String, Set<String>> allowed = new HashMap<>();
    private AccessControlService() { }

    public static AccessControlService getInstance() {
        return INSTANCE;
    }

    public void allow(String docId, String username) {
        allowed.computeIfAbsent(docId, k -> new HashSet<>()).add(username);
    }

    public boolean isAllowed(String docId, String username) {
        return allowed.getOrDefault(docId, Collections.emptySet()).contains(username);
    }
}
