package io.github.kozlovva.os.domain.order.exception;

import io.github.kozlovva.core.caf.exception.DomainException;

public class OrderAlreadyCancelledException extends DomainException {
    public OrderAlreadyCancelledException() {
        super("Order already cancelled");
    }
}
