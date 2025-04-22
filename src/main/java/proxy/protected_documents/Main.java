package main.java.proxy.protected_documents;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // users
        User max = new User("max");
        User ivan   = new User("ivan");

        // library setup
        Library lib = new Library();
        lib.addUnprotected("doc-public", "Public document!");

        // authorized users
        lib.addProtected("doc-secret", "Secret document!", Set.of("ivan"));

        tryPrint(lib, "doc-public", max);
        tryPrint(lib, "doc-public", ivan);

        tryPrint(lib, "doc-secret", max);   // allowed
        tryPrint(lib, "doc-secret", ivan);     // denied
    }

    private static void tryPrint(Library lib, String docId, User user) {
        System.out.printf(">>> %s tries to read %s%n", user.getUsername(), docId);
        try {
            String content = lib.get(docId).getContent(user);
            System.out.println("SUCCESS: " + content);
        } catch (AccessDeniedException e) {
            System.out.println("DENIED: " + e.getMessage());
        }
        System.out.println();
    }
}
