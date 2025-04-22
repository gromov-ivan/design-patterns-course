package main.java.proxy.protected_documents;

class DocumentProxy implements DocumentResource {

    private final Document realDocument;               // the protected document
    private final AccessControlService acs = AccessControlService.getInstance();

    DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
    }

    @Override public String getId() { return realDocument.getId(); }

    @Override public String getCreationDate() {
        // creation date is public – no access check
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (acs.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);      // delegate to the real object
        }
        throw new AccessDeniedException(
                "User '" + user.getUsername() + "' is not allowed to read document " + getId());
    }
}

