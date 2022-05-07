package io.github.kozlovva.os.domain.order.exception;

import io.github.kozlovva.core.caf.exception.DomainException;

public class OrderAlreadyCompletedException extends DomainException {
    public OrderAlreadyCompletedException() {
        super("Order already completed");
    }
}
