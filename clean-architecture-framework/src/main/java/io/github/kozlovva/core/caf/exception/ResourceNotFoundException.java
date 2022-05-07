package io.github.kozlovva.core.caf.exception;

public class ResourceNotFoundException extends DomainException {

    public ResourceNotFoundException(String domain, String id) {
        super("Resource " + domain + " not found by ID " + id);
    }
}
