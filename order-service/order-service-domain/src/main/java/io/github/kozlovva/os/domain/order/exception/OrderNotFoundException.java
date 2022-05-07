package io.github.kozlovva.os.domain.order.exception;

import io.github.kozlovva.core.caf.exception.ResourceNotFoundException;

public class OrderNotFoundException extends ResourceNotFoundException {

    public OrderNotFoundException(String id) {
        super("Order", id);
    }
}
