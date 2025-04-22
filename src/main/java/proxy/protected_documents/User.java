package main.java.proxy.protected_documents;

class User {
    private final String username;
    User(String username) { this.username = username; }
    public String getUsername() { return username; }
}

class AccessDeniedException extends Exception {
    public AccessDeniedException(String msg) { super(msg); }
}

