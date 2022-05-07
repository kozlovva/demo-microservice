package io.github.kozlovva.os.domain.customer.exception;

import io.github.kozlovva.core.caf.exception.ResourceNotFoundException;

public class CustomerNotFoundException extends ResourceNotFoundException {

    public CustomerNotFoundException(String id) {
        super("Customer", id);
    }
}
