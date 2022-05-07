package io.github.kozlovva.os.domain.order.exception;

import io.github.kozlovva.core.caf.exception.DomainException;

public class OrderAlreadyPayedException extends DomainException {
    public OrderAlreadyPayedException() {
        super("Order already payed");
    }
}
